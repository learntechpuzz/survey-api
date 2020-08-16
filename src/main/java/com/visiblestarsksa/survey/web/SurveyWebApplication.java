package com.visiblestarsksa.survey.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.visiblestarsksa.survey")
@ConfigurationPropertiesScan("com.visiblestarsksa.survey.core.config")
@EntityScan(basePackages = "com.visiblestarsksa.survey.core.model")
@EnableJpaRepositories(basePackages = "com.visiblestarsksa.survey.core.repository")
public class SurveyWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyWebApplication.class, args);
    }
}
