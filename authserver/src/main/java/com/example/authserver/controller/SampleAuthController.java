package com.example.authserver.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sample REST controller
 * 
 * Created by juncevich on 6/15/17.
 */
@RestController
public class SampleAuthController {

    @RequestMapping("/user")
    public Principal user(Principal user) {

        return user;
    }
}
