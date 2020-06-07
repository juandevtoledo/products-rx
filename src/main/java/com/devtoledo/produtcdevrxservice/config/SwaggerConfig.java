package com.devtoledo.produtcdevrxservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebFlux
public class SwaggerConfig {


    @Bean
    public Docket api() {
        ArrayList arrayList=new ArrayList();
        arrayList.add(securityContext());
        return new Docket(DocumentationType.SWAGGER_2).enable(true)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(apiKey())
                .securityContexts(arrayList)
                .apiInfo(
                        new ApiInfoBuilder()
                                .version("1.0.1")
                                .title("Online store API")
                                .description("Documentation Online Store API v1.0")
                                .contact( new Contact("team","http://juandevToledo.com/", "juandev@dev.academy" ))
                                .build() );
    }

    @Bean
    SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        ArrayList arrayList=new ArrayList();
        arrayList.add(new SecurityReference("JWT", authorizationScopes));
        return arrayList;
    }

    private List<ApiKey> apiKey() {
        ArrayList arrayList=new ArrayList();
        arrayList.add(new ApiKey("JWT", "Authorization", "header"));
        return arrayList;
    }

}