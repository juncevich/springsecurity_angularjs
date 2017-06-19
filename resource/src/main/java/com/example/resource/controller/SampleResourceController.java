package com.example.resource.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resource.dto.Change;
import com.example.resource.dto.Message;

/**
 * Sample REST controller
 * 
 * Created by juncevich on 6/15/17.
 */
@RestController
public class SampleResourceController {

    private String message = "Hello World";

    private List<Change> changes = new ArrayList<>();

    @RequestMapping(value = "/",
            method = RequestMethod.GET)
    public Message home() {

        return new Message(message);
    }

    @RequestMapping(value = "/changes",
            method = RequestMethod.GET)
    public List<Change> changes() {

        return changes;
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST)
    public Message update(@RequestBody Message map, Principal principal) {

        if (map.getContent() != null) {
            message = map.getContent();
            changes.add(new Change(principal.getName(), message));
            while (changes.size() > 10) {
                changes.remove(0);
            }
        }
        return new Message(message);
    }

}
