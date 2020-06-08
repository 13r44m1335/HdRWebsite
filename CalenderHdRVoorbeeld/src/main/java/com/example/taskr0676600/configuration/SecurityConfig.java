package com.example.taskr0676600.configuration;

import com.example.taskr0676600.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/css/style.css").permitAll()
                .mvcMatchers("/images/*").permitAll()
                .mvcMatchers("/index").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/signup").permitAll()
                .mvcMatchers("/error").permitAll()
                .mvcMatchers("/tasks").hasAnyAuthority("USER","ADMIN")
                .mvcMatchers("/tasks/{spring:[0-9]+}").hasAnyAuthority("USER","ADMIN")
                .mvcMatchers("/tasks/*").hasAuthority("ADMIN")
                .mvcMatchers("/tasks/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().formLogin().defaultSuccessUrl("/", true)
                .and().logout().logoutUrl("/logout").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
    }
}


/* -- in memory roles
@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .mvcMatchers("/css/style.css").permitAll()
                .mvcMatchers("/images").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/signup").permitAll()
                .mvcMatchers("/tasks").hasRole("USER")
                .mvcMatchers("/tasks/{spring:[0-9]+}").hasRole("USER")
                .mvcMatchers("/tasks/new").hasRole("ADMIN")
                .mvcMatchers("/tasks/*").hasRole("ADMIN")
                .mvcMatchers("/tasks/**").hasRole("ADMIN")
                .mvcMatchers("/tasks/***").hasRole("ADMIN")
                .mvcMatchers("/tasks/****").hasRole("ADMIN")
                .mvcMatchers("/tasks/*****").hasRole("ADMIN")

                .anyRequest().authenticated()
                .and().formLogin().loginProcessingUrl("/login_succes").loginPage("/login").permitAll()
                .and().logout().logoutUrl("/logout")
                .and().formLogin().defaultSuccessUrl("/tasks", true);



        httpSecurity.csrf().disable();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("{noop}t").roles("USER")
                .and()
                .withUser("admin").password("{noop}t").roles("USER","ADMIN");

    }




}*/
