package com.itbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

//@EnableDubbo
@SpringBootApplication
@EnableJms
public class TmallFreemakerStaticpageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallFreemakerStaticpageServiceApplication.class, args);
	}
	
}
