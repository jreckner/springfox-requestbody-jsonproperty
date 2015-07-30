package com.test

import static com.google.common.base.Predicates.or
import static springfox.documentation.builders.PathSelectors.regex

import com.google.common.base.Predicate
import com.google.common.collect.Sets
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@ComponentScan(basePackages = ['com.test.*'])
@EnableAutoConfiguration
@Slf4j
class Application {

    static void main(String... args) {
        SpringApplication.run(Application, args)
    }

    @Bean
    Docket myApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName('my-api')
                .apiInfo(apiInfo())
                .select().paths(myPaths())
                .build()
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .protocols(Sets.newHashSet('http'))
                .ignoredParameterTypes(MetaClass)
                .useDefaultResponseMessages(false)
    }

    private Predicate<String> myPaths() {
        return or(regex('/api/.*'))
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder(
                title: 'My API',
                description: '',
                termsOfServiceUrl: '',
                contact: '',
                license: 'Apache License Version 2.0',
                licenseUrl: '',
                version: '0.1'
        ).build()
    }
}
