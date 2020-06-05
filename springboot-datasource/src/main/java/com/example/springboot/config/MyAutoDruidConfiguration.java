package com.example.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-11 23:42
 */
@Configuration
@ConditionalOnClass(value = {DruidDataSource.class})
@EnableConfigurationProperties(MyDruidProperties.class)
public class MyAutoDruidConfiguration {
    private Log log = LogFactory.getLog(MyAutoDruidConfiguration.class);
    @Autowired
    private MyDruidProperties properties;

    @Bean(initMethod = "init")
    public DruidDataSource druidDataSource() {
        if (null == properties.getUrl()) {
            log.error("url can not be null");
            throw new RuntimeException("url can not be null");
        }
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setMaxActive(properties.getMaxActive());
        dataSource.setMaxIdle(properties.getMaxIdle());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setValidationQuery(properties.getValidationQuery());
        return dataSource;
    }

    /**
     * 注册监听页面的Servlet
     */
    @Bean
    @ConditionalOnClass(value = {StatViewServlet.class})
    public ServletRegistrationBean<StatViewServlet> registrationBean() {
        //创建注册器
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>();
        //创建servlet
        StatViewServlet servlet = new StatViewServlet();
        //注册
        bean.setServlet(servlet);
        //注入相关参数
        bean.addInitParameter("loginUsername", properties.statView.getLoginUsername());
        bean.addInitParameter("loginPassword", properties.statView.getLoginPassword());
        bean.addInitParameter("allow", properties.statView.getAllow());
        bean.addInitParameter("deny", properties.statView.getDeny());
        //设置映射
        if (properties.statView.getUrlMapping() == null || properties.statView.getUrlMapping().length == 0) {
            log.error("监控的urlMapping不能为空");
            throw new RuntimeException("监控的urlMapping不能为空");
        }
        bean.addUrlMappings(properties.statView.getUrlMapping());
        return bean;
    }
}
