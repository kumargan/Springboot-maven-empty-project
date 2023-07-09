package com.api.authenticator;

import com.api.authenticator.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableSwagger2
@ComponentScan(basePackages = { "com" })
@Slf4j
public class AuthenticatorApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticatorApp.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {
        log.info("*************** started application *****************");
    }
}