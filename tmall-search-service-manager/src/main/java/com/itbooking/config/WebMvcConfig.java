package com.itbooking.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class WebMvcConfig implements WebMvcConfigurer {
    
	// 就是这个
    @Bean
    public FormContentFilter formContentFilter() {
        return new FormContentFilter();
    }

}