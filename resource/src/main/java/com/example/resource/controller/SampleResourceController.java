package com.example.resource.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resource.dto.Message;

/**
 * Sample REST controller
 * 
 * Created by juncevich on 6/15/17.
 */
@RestController
public class SampleResourceController {

    @RequestMapping("/")
    @CrossOrigin(origins = "*",
            maxAge = 3600)
    public Message home() {

        return new Message("Hello World");
    }

}
