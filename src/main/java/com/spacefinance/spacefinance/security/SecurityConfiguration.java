package com.spacefinance.spacefinance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Kasia").password("{noop}mysza300").roles("USER","ADMIN")
                .and()
                .withUser("Kamil").password("{noop}mysza300").roles("USER","ADMIN")
                .and()
                .withUser("user").password("{noop}user").roles("USER","ADMIN");

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
               .antMatchers("/","/about","/assets/**").permitAll()
                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("USER")
                .anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/")
                .and().logout().logoutSuccessUrl("/");
    }
}
