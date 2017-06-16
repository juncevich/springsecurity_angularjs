package com.example.authserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Authenticate server config
 */
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class SampleAuthConfig extends WebMvcConfigurerAdapter {

}
