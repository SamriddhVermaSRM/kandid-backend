package com.kandid.backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(req -> req.requestMatchers(HttpMethod.POST).permitAll());
        http.authorizeHttpRequests(req -> req.requestMatchers(
                "/api/forms/**"
                ).hasRole("ADMIN"));
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails Samriddh = User.withUsername("The CTO").password(passwordEncoder().encode("CTO hu bc")).roles("ADMIN").build();
        UserDetails Keshav = User.withUsername("ceo.kandid24").password(passwordEncoder().encode("keshav12122003")).roles("ADMIN").build();
        UserDetails Bhramari = User.withUsername("bhramari22").password(passwordEncoder().encode("22814dec")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(Samriddh, Keshav, Bhramari);
    }
}
