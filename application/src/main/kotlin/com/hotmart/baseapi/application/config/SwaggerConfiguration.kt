package com.hotmart.baseapi.application.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerConfiguration {
    @Bean
    fun api(): Docket {
        val basePackage = RequestHandlerSelectors.basePackage("com.hotmart.baseapi.application")
        val apiUrls = PathSelectors.ant("/**")
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(basePackage)
            .paths(apiUrls)
            .build()
    }
}