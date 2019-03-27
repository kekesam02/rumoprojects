package com.itbooking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.itbooking.mapper")
@EnableJms
public class TmallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmallAdminApplication.class, args);
    }

}
