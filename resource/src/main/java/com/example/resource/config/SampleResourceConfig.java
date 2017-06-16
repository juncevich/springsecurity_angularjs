package com.example.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Resource security config
 */
@Configuration
public class SampleResourceConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }

}
