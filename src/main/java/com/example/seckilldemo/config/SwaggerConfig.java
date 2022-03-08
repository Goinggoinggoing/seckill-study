package com.example.seckilldemo.config;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @Author: lichao
 * @Description: swagger配置
 * @Date 2022/03/07
 * @ClassName: SwaggerConfig
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //不显示springboot的BasicErrorControllere类接口
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "",
                "",
                "API V1.0",
                "Terms of service",
                new Contact("zwzgame", "http://127.0.0.1:8080/doc.html", ""),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
