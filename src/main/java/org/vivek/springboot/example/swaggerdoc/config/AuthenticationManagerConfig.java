package org.vivek.springboot.example.swaggerdoc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableConfigurationProperties(ApplicationClients.class)
public class AuthenticationManagerConfig extends
        GlobalAuthenticationConfigurerAdapter {

    @Autowired
    ApplicationClients application;
    private static final String ENCODED_PASSWORD = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        for (ApplicationClient client : application.getClients()) {


            auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                    .withUser(client.getUsername()).password(ENCODED_PASSWORD).roles(client.getRoles());
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}