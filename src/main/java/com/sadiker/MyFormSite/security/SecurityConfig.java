package com.sadiker.MyFormSite.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityImp securityImp() {
        return new SecurityImp();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("", "/", "/home","/createUser","/saveUser","/showAllIssue","/showIssue/**")
                .permitAll()
                .requestMatchers("/createIssue").hasAnyAuthority("NORMAL","ADMIN")
                .requestMatchers("/showAllUser/**","/deleteIssue/**","/deleteComment/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .and()
                .httpBasic()
                .and()
                .userDetailsService(securityImp())
                .build();

    }

    
    
}
