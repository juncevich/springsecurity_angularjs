package com.example.resource.config;

import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * Resource security config
 */
@Configuration
@EnableResourceServer
public class SampleResourceConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public WebRequestTraceFilter webRequestLoggingFilter(ErrorAttributes errorAttributes,
            TraceRepository traceRepository, TraceProperties traceProperties) {

        WebRequestTraceFilter filter = new WebRequestTraceFilter(traceRepository, traceProperties);
        if (errorAttributes != null) {
            filter.setErrorAttributes(errorAttributes);
        }
        filter.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 1);
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // We need this to prevent the browser from popping up a dialog on a 401
        http.httpBasic().disable().csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/**").hasRole("WRITER").anyRequest()
                .authenticated();
    }
}
