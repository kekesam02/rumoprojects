package com.itbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.itbooking.repository")
//@EnableDubbo
@EnableJms
public class TmallSearchEnginFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallSearchEnginFrontApplication.class, args);
	}

}

