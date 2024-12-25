package br.com.renequeiroz.api.pedidos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenApiConfig {

    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .info(new Info().title("API de Pedidos")
                        .description("API de Pedidos")
                        .version("v1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(new Contact().name("Rene Queiroz").email("renequeiroz@gmail.com")));
    }
}
