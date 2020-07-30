package org.vivek.springboot.example.swaggerdoc.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@ConditionalOnWebApplication
@EnableConfigurationProperties(ApplicationClients.class)
@RequiredArgsConstructor
@Slf4j

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	 private ApplicationClients application;

	private static final String[] AUTH_LIST = { //
			"/v2/api-docs", //
			"/configuration/ui", //
			"/swagger-resources", //
			"/configuration/security", //
			"/swagger-ui.html", //
			"/webjars/**" //
	};

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeRequests()
	            .requestMatchers(EndpointRequest.to("health")).permitAll()
	            .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
	            .antMatchers(AUTH_LIST).authenticated()
	            .and()
	            .cors()
	            .and()
	            .httpBasic();
	    }


}