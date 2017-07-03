package com.example.gateway.controller

import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.security.Principal
import java.util.*

/**
 * Simple REST controller
 */
@RestController
class GatewayController {

    @RequestMapping("/user")
    @ResponseBody
    fun user(user: Principal): Map<String, Any> {

        val map = LinkedHashMap<String, Any>()
        map.put("name", user.name)
        map.put("roles",
                AuthorityUtils.authorityListToSet((user as Authentication).authorities))
        return map
    }

    @RequestMapping("/login")
    fun login(): String {

        return "forward:/"
    }
}
