package com.example.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security config
 */
@Configuration
public class AdminConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()
                .antMatchers("/index.html", "/unauthenticated.html", "/").permitAll().anyRequest()
                .hasRole("ADMIN").and().csrf().disable();
    }

}
