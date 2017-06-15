package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Message;

/**
 * Sample REST controller
 * 
 * Created by juncevich on 6/15/17.
 */
@RestController
public class SampleResourceController {

    @RequestMapping("/")
    public Message home() {

        return new Message("Hello World");
    }

}
