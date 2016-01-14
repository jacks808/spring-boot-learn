/*
 * spring-boot-learn - com.beenoisy.springboot.BootConfig.java
 * ziyi.wang
 */
package com.beenoisy.springboot;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.beenoisy.springboot.interceptor.LogInterceptor;

/**
 * spring boot config
 * 
 * @author ziyi.wang<br>
 */
@Component
public class BootConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(
                    InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/*");
    }
}
