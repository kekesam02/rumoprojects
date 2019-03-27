package com.itbooking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.itbooking.mapper")
public class TmallContentsServiceManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallContentsServiceManagerApplication.class, args);
	}

}