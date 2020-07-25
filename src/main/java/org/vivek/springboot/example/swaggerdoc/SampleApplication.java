package org.vivek.springboot.example.swaggerdoc;

import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.HandlerMethod;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	/*
	 * @Bean public OpenAPI customOpenAPI() { return new OpenAPI().info(new
	 * Info().title("title").version("version").description("description"))
	 * .addSecurityItem(new SecurityRequirement().addList("my security"))
	 * .components(new Components().addSecuritySchemes("my security", new
	 * SecurityScheme().name("my security").type(SecurityScheme.Type.HTTP).scheme(
	 * "bearer"))); }
	 */

	@Bean
	public OperationCustomizer customGlobalHeaders() {

		return (Operation operation, HandlerMethod handlerMethod) -> {

			Parameter xForwardedFor = new Parameter().in(ParameterIn.HEADER.toString()).schema(new StringSchema())
					.name("X-Forwarded-For").description("Originating application or client using the service")
					.required(false);

			operation.addParametersItem(xForwardedFor);

			return operation;
		};
	}

	
	 @Bean
	    public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
	     return new OpenAPI()
	          .info(new Info()
	          .title("sample application API")
	          .version(appVersion)
	          .description(appDesciption)
	          .termsOfService("http://swagger.io/terms/")
	          .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	    }

	/*
	 * @Bean ForwardedHeaderFilter forwardedHeaderFilter() { return new
	 * ForwardedHeaderFilter(); }
	 */
}
