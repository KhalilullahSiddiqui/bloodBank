package com.blood.testing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
        http
                        .formLogin()
                        .loginPage("/login").permitAll();
        http
                        .logout().logoutSuccessUrl("/login");
        http.headers().frameOptions().disable();
        http
                .httpBasic();
        /*http
            .csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/api/v1/post/detailfragment/**").hasRole("ADMIN")
    //.mvcMatchers("/api/v1/detailfragment/**").hasAuthority("write")
    //.mvcMatchers("/api/v1/detailfragment/**}").hasAnyRole("ADMIN","USER")
                 .mvcMatchers(HttpMethod.GET,"/api/v1/detailfragment}").hasAuthority("read")
                .anyRequest()
                .authenticated();*/
}

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
