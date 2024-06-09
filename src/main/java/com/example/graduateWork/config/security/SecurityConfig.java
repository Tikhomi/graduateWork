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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/api/register", "/api/login","/api/send-sms", "/api/verify-code").permitAll()
                .antMatchers("/api/appointments", "/api/appointment/add", "/api/appointment/del/{id_appointment}"
                        , "/api/reports/generateAllExcel"
                        , "/api/reports/generateLastYearReport", "/api/payment/add"
                        , "/api/payment/del/{id_payment}", "/api/service/add", "/api/service/del/{id_service}")
                .hasRole("ADMIN")

                .antMatchers("/api/appointment/{id_appointment}", "/api/payments")
                .hasAnyRole("ADMIN", "DOCTOR", "PATIENT")

                .antMatchers("/api/services", "/api/service/{id_service}", "/doctor/add", "/doctor/all", "/appointment/add", "/appointment/all",
                        "/service/add", "/appointment/del/{idAppointment}",
                        "/payment/add","/doctor/del/{idDoctor}", "/client/add", "/api/reports/generateLastMonthReport", "/client/all", "/client/del/{idClient}"
                            , "/payment/all", "/payment/del/{idPayment}", "/service/del/{id_service}", "/service/all")//добавить сюда еще список врачей
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/api/services")
                .and()
                .logout()
                .logoutSuccessUrl("/api/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT phone_number, password, 1 FROM users WHERE CAST(phone_number AS VARCHAR) = ?")
                .authoritiesByUsernameQuery("SELECT phone_number, role FROM users WHERE CAST(phone_number AS VARCHAR) = ?")
                .passwordEncoder(passwordEncoder());
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}