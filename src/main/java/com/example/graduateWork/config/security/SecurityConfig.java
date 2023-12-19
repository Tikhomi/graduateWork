package com.example.graduateWork.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/autoriz").permitAll()
                .antMatchers("/api/appointments","/api/appointment/add", "/api/appointment/del/{id_appointment}").hasRole("ADMIN")
                .antMatchers("/api/appointment/{id_appointment}").hasAnyRole("ADMIN", "DOCTOR", "PATIENT") //.authenticated()

                .antMatchers("/api/payments","/api/payment/add", "/api/payment/del/{id_payment}").hasRole("ADMIN")
                .antMatchers("/api/appointment/{id_payment}").hasAnyRole("ADMIN", "DOCTOR", "PATIENT") //.authenticated()

                .antMatchers("/api/services").permitAll()
                .antMatchers("/api/services","/api/service/add", "/api/service/del/{id_service}").hasRole("ADMIN")
                .antMatchers("/api/service/{id_service}").hasAnyRole("ADMIN", "DOCTOR", "PATIENT") //.authenticated()
//
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/api/services")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login");

                /*
                * начало рабочий вариант с  формой
                * */
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/api/services")
                .and()
                .logout()
                .logoutSuccessUrl("/login");
                /*
                * конец рабочий вариант с  формой
                 * */

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT phone_number, password, 1 FROM users WHERE phone_number = ?")
                .authoritiesByUsernameQuery("SELECT phone_number, role FROM users WHERE phone_number = ?")
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}