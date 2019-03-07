package com.itbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
public class TmallFrontApplication{

	public static void main(String[] args) {
		SpringApplication.run(TmallFrontApplication.class, args);
	}

}

