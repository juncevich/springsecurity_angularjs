package com.example.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.resource")
public class ResourceApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResourceApplication.class, args);
    }

}
