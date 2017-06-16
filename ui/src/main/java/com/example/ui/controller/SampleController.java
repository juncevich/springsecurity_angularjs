package com.example.ui.controller;

import java.security.Principal;

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

}
