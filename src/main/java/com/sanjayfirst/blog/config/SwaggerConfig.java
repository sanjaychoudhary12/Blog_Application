package com.sanjayfirst.blog.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.In;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Blogging Application : Backend Course")
                        .description("This project is developed by Learn Code With Durgesh")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Durgesh")
                                .url("https://learncodewithdurgesh.com")
                                .email("learncodewithdurgesh@gmail.com")))
                .addSecurityItem(new SecurityRequirement().addList("JWT"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("JWT", new SecurityScheme()
                                .name(AUTHORIZATION_HEADER)
                                .type(Type.APIKEY)
                                .in(In.HEADER)));
    }
}
