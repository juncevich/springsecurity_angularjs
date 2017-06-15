package com.example.ui.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST controller
 */
@RestController
public class SampleController {

    @RequestMapping("/user")
    public Principal user(Principal user) {

        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {

        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session) {

        return Collections.singletonMap("token", session.getId());
    }
}
