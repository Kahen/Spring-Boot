package com.example.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 李家幸
 * @class 计科三班
 * @create 2020-01-11 23:42
 */
@ConfigurationProperties(prefix = "spring.druid")
@Data
public class MyDruidProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    /**
     * 初始化
     */
    private Integer initialSize;
    /**
     * 最大活跃连接数
     */
    private Integer maxActive;
    /**
     * 最大连接数
     */
    private Integer minIdle;
    /**
     * 最小连接数
     */
    private Integer maxIdle;
    /**
     * 连接检查语句
     */
    private String ValidationQuery;
    //监控的属性

    StatView statView;


    @Data
    static class StatView {
        private String LoginUsername;
        private String LoginPassword;
        private String allow;
        private String deny;
        private String[] urlMapping;
    }
}
