package com.itbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class TmallActivemqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmallActivemqConsumerApplication.class, args);
	}

}
