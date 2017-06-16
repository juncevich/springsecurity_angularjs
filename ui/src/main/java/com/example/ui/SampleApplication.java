package com.example.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.ui")
public class SampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(SampleApplication.class, args);
    }
}
