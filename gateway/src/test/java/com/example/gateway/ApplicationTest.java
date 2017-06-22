package com.example.gateway;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by juncevich on 6/22/17.
 */
@SpringBootApplication
@Controller
public class ApplicationTest {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ApplicationTest.class)
                .properties("server.port=9999", "security.basic.enabled=false").run(args);
    }

    @RequestMapping("/")
    public String home() {

        return "forward:/test.html";
    }
}
