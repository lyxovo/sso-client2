package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 此配置是可解决跨域请求问题，但是拦截器会失效。原因：
 * 请求经过的先后顺序问题，当请求到来时会先进入拦截器中，而不是进入Mapping映射中
 */
//@Configuration
//public class MvcConfig extends WebMvcConfigurationSupport {
//    @Override
//    protected void addCorsMappings(CorsRegistry registry) {
//        super.addCorsMappings(registry);
//        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//    }
//}

