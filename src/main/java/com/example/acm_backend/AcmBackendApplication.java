package com.example.acm_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class AcmBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcmBackendApplication.class, args);
    }

}
