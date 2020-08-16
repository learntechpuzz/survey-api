package com.visiblestarsksa.survey.web.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage(
                                "com.visiblestarsksa.survey.web.controllers"))
                .paths(regex("/api/survey.*"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        ApiInfo apiInfo =
                new ApiInfo(
                        "Survey Management REST API",
                        "Survey Management REST API",
                        "1.0",
                        "Terms of service",
                        new Contact("Hakkim Badhusha", "", "hakkim@visiblestarsksa.com"),
                        "",
                        "",
                        vendorExtensions);
        return apiInfo;
    }
}
