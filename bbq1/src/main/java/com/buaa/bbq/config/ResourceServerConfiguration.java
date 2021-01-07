package com.buaa.bbq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .exceptionHandling()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/bbq/**").hasAnyAuthority("systembbq")
                .antMatchers("/bbq/bbqLike/").hasAnyAuthority("systembbq")
                .antMatchers("/bbq/bbqcommentLike/").hasAnyAuthority("systembbq")
                .antMatchers("/bbq/bbqcomment/").hasAnyAuthority("systembbq")
                .antMatchers("/bbq/bbqimage/").hasAnyAuthority("systembbq");
    }

}