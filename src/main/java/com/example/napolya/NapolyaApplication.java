package com.example.napolya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class NapolyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NapolyaApplication.class, args);

    }
}