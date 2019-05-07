package com.example.demo.utility;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author djs
 * @version 1.0
 * @time 2019/4/4 17:42
 * @description 跨域配置
 */
@Configuration
public class DomainConfiguration extends WebMvcConfigurerAdapter {
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");

    }
}
