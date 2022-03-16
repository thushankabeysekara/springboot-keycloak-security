package com.example.thushan.core.keycloaksecurity.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    /**
     * we are required to explicitly define a KeycloakSpringBootConfigResolver bean to make Spring Boot
     * resolve the Keycloak configuration from application.properties correctly
     * @return
     */
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}
