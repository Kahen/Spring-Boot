package com.example.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.realm.UserRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kahen
 * @create 2020-01-19 20:45
 */
@Configuration
@EnableConfigurationProperties(ShiroProperties.class)
public class ShiroAutoConfiguration {
    @Autowired
    private ShiroProperties shiroProperties;

    /**
     * 创建凭证匹配器
     */
    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(shiroProperties.getHashAlgorithmName());
        credentialsMatcher.setHashIterations(shiroProperties.getHashIteration());
        return credentialsMatcher;
    }

    /**
     * 创建realm
     */
    @Bean
    public UserRealm userRealm(CredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    /**
     * 声明安全管理器
     */
    @Bean("secuityManager")
    public SecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 配置过滤器 Shiro 的web过滤器id 必须和web.xml里面的shiroFilter的targetBean的值一样
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //注入安全管理器
        bean.setSecurityManager(securityManager);
        //注入登录页面
        bean.setLoginUrl(shiroProperties.getLoginUrl());
        //注入未授权的页面地址
        bean.setUnauthorizedUrl(shiroProperties.getUnAuthorizeUrl());
        //注入过滤器
        Map<String, String> filterChainDefinition = new HashMap<>();
        //注入放行地址
        if (shiroProperties.getAnonUrls() != null && shiroProperties.getAnonUrls().length > 0) {
            String[] anonUrls = shiroProperties.getAnonUrls();
            for (String anonUrl : anonUrls) {
                filterChainDefinition.put(anonUrl, "authc");
            }
        }
        //注入拦截地址
        String[] authUrls = shiroProperties.getAuthUrls();
        if (authUrls != null && authUrls.length > 0) {
            for (String authUrl : authUrls) {
                filterChainDefinition.put(authUrl, "authc");
            }
        }
        bean.setFilterChainDefinitionMap(filterChainDefinition);
        return bean;
    }

    /**
     * 注册过滤器
     */
    @Bean("delegatingFilterProxy")
    public FilterRegistrationBean<DelegatingFilterProxy> filterProxyFilterRegistrationBean() {
        FilterRegistrationBean<DelegatingFilterProxy> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        //配置过滤器
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        filterFilterRegistrationBean.setFilter(proxy);
        filterFilterRegistrationBean.addInitParameter("targetFilterLifecycle", "true");
        List<String> servletNames = new ArrayList<>();
        servletNames.add(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
        filterFilterRegistrationBean.setServletNames(servletNames);
        return filterFilterRegistrationBean;
    }

    /**
     * 这里是为了能在html页面引用shiro标签，上面两个函数必须添加，不然会报错
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
