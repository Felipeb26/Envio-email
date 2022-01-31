package com.projeto.email.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
		@Bean
		public Docket api(
				@Value("felipe.silva@gmail.com") String contato) {
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.projeto.email"))
					.paths(PathSelectors.any())
					.build()
					.useDefaultResponseMessages(true)
					.apiInfo(apiInfo());
		}
		
	    private ApiInfo apiInfo() {
	        return new ApiInfo(
	                "Projetos Batl",
	                "API Envio de Email.",
	                "1.0",
	                "Termos de serviço",
	                new Contact("felipe", "https://github.com/Felipeb26", "felipe.silva@grupomultiplica.com.br"),
	                "License of API",
	                "API license URL",
	                Collections.emptyList());
	    }
}
