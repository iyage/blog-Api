package com.blog.restapi_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@Configuration
@EnableSwagger2
public class RestapiBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiBlogApplication.class, args);
    }


    @Bean
    public Docket SwaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blog.restapi_blog"))
                .build()
                .apiInfo(apiDetails());


    }


    private ApiInfo apiDetails(){
        return new ApiInfo (
                "Blog Api",
                "Design by ofunrein iyaghe for Bridgeheadtech",
                "1.0",
               "Free to use",
        new springfox.documentation.service.Contact("Ofunrein Iyaghe","https://github.com/iyage","yahg.concept@gmail.com"),
                        "API License",
                        "https://github.com/iyage",
                        Collections.emptyList());
    }
}

