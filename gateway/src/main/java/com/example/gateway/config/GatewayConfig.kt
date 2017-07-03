package com.example.gateway.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

/**
 * Security config
 */
@Configuration
@EnableZuulProxy
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class GatewayConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    @Throws(Exception::class)
    fun globalUserDetails(auth: AuthenticationManagerBuilder) {

        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
                .and().withUser("audit").password("audit").roles("USER", "ADMIN", "READER")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        http.httpBasic().and().logout().and().authorizeRequests()
                .antMatchers("/index.html", "/login", "/").permitAll().anyRequest().authenticated()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
    }

}
