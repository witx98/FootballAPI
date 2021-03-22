package com.mwitkowski.footballapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class FootballRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballRestApplication.class, args);

    }
    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .build()
                .apiInfo(new ApiInfo(
                        "FootballApp",
                        "Project for II - REST API",
                        "1.00",
                        "https://github.com/KISiM-AGH/projekt-zaliczeniowy-es-mw/tree/master",
                        new Contact("Ewelina and Mateusz", "https://github.com/KISiM-AGH/projekt-zaliczeniowy-es-mw/tree/master", "email@email.com"),
                        "our onw licence",
                        "https://github.com/KISiM-AGH/projekt-zaliczeniowy-es-mw/tree/master",
                        Collections.emptyList()
                ));
    }

}
