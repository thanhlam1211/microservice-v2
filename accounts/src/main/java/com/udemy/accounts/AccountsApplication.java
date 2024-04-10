package com.udemy.accounts;

import com.udemy.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//Invoke bean name auditorAwareImpl with define current audit
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = AccountsContactInfoDto.class)
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts service API Documentation",
                description = "Accounts service API Documentation in microservices",
                version = "1.0.0",
                contact = @Contact(
                        name = "Lam Bui",
                        url = "https://www.udemy.com",
                        email = "lambui@example.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
        description =  "Bank of Accounts microservice REST API Documentation",
        url = "https://www.google.com"
)
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
