package com.api.authenticator.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile({"default", "local", "dev", "stg", "perf", "preprod"}) // comment if swagger is not
                                                                // required on
// all profiles
public class SwaggerConfig {
  @Bean
  public Docket productApi() {
    List<Parameter> aParameters = new ArrayList<>();
    ParameterBuilder aParameterBuilder1 = new ParameterBuilder();
    aParameterBuilder1.name("x-user-agent").modelRef(new ModelRef("string")).parameterType("header")
        .defaultValue(
            "{\"platform\":\"android\",\"app_version\":\"2.1.2602-development\",\"device_id\":\"2933\",\"model\":\"motorola Moto G (5S)\",\"os_version\":25,\"user_id\":\"234\"}")
        .required(true).build();
    aParameters.add(aParameterBuilder1.build());

    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.api.authenticator.controller.api"))
        .paths(PathSelectors.regex("/.*")).build().apiInfo(metaData())
        .globalOperationParameters(aParameters);
  }

  private ApiInfo metaData() {
    @SuppressWarnings("deprecation")
    ApiInfo apiInfo = new ApiInfo("Data", "Rest APIs for data", "1.0",
        "Terms ", "data", "",
        "email");
    return apiInfo;
  }
}
