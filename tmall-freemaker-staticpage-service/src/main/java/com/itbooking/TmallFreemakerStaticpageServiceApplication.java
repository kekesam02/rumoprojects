package com.itbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
public class TmallFreemakerStaticpageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallFreemakerStaticpageServiceApplication.class, args);
	}
	
}
