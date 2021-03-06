package com.example.admin.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST controller
 */
@RestController
public class AdminController {

    @RequestMapping("/user")
    public Map<String, Object> user(Principal user) {

        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", user.getName());
        map.put("roles",
                AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
        return map;
    }
}
