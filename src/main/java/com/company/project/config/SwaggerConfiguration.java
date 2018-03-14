package com.company.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${swagger2.defaultGroupName}")
    protected String defaultGroupName;
    @Value("${swagger2.defaultBasePackage}")
    protected String defaultBasePackage;
    @Value("${swagger2.defaultTitle}")
    protected String defaultTitle;
    @Value("${swagger2.defaultDescription}")
    protected String defaultDescription;
    @Value("${swagger2.defaultTermsOfServiceUrl}")
    protected String defaultTermsOfServiceUrl;
    @Value("${swagger2.defaultVersion}")
    protected String defaultVersion;

    @Bean
    public Docket defaultRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(defaultGroupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(defaultBasePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(defaultTitle)
                .description(defaultDescription)
                .termsOfServiceUrl(defaultTermsOfServiceUrl)
//                .contact()
                .version("1.0")
                .build();
    }
}
