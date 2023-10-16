package com.example.health.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
    public class SecurityConfig {
    private final AutenticacaoFilter autenticacaoFilter;
    public SecurityConfig(AutenticacaoFilter filtro){
        this.autenticacaoFilter = filtro;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(crsf-> crsf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->
                        auth.requestMatchers(HttpMethod.POST,"/login").permitAll()
                                .requestMatchers(HttpMethod.POST,"/usuario").permitAll()
                                .requestMatchers(HttpMethod.GET,"/usuario").hasAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST, "/paciente").hasAnyAuthority("ROLE_MEDICO","ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET,"/paciente").hasAnyAuthority("ROLE_PACIENTE","ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST,"/prontuario").hasAnyAuthority("ROLE_MEDICO","ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET,"/prontuario").hasAnyAuthority("ROLE_MEDICO","ROLE_ADMIN")
                                .requestMatchers(HttpMethod.POST,"/medico").hasAnyAuthority("ROLE_ADMIN")
                                .requestMatchers(HttpMethod.GET,"/medico").hasAnyAuthority("ROLE_MEDICO", "ROLE_ADMIN")
                                .anyRequest().authenticated())
                .addFilterBefore(this.autenticacaoFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception{
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
