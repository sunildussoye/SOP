package com.salesorderprocessing.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Sunil Dussoye", "sunil@mauritius.com", "dussoyesunil@gmail.com");

    // Signatures from the Apinfo.class itself
    private static final ApiInfo DEFAULT_API_INFO =
            new ApiInfo("Api Documentation", "Sales Order Processing Documentation",
                    "1.0", "sunildussoye@gmail.com(for TOC)", DEFAULT_CONTACT,
                    "Apache 2.0",
                    "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO);
    }
}

