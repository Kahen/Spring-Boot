package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Kahen
 * @create 2020-01-19 20:47
 */
@ConfigurationProperties(value = "shiro")
@Data
public class ShiroProperties {
    private String hashAlgorithmName = "md5";
    private Integer hashIteration = 2;
    private String loginUrl;
    private String unAuthorizeUrl;
    private String[] anonUrls;
    private String loutUrl;
    private String[] authUrls;
}
