package org.vivek.springboot.example.swaggerdoc.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi30Config {

  /*  public OpenApi30Config() {

    }

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}")
                                         String appDesciption, @Value("${application-version}") String appVersion) {
        final String securitySchemeName = "bearerAuth"; // final String apiTitle =

        return new
                OpenAPI()
				.addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
				.components(new Components().addSecuritySchemes(securitySchemeName, new SecurityScheme().name(securitySchemeName).type(SecurityScheme.Type.HTTP).scheme("basic") ))
				.info(new Info().title("sample application API").version(appVersion).description(appDesciption).termsOfService("http://swagger.io/terms/").license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
*/
}