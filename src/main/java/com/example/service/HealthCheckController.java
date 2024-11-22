package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private Environment env;

    @GetMapping("/status")
    public ResponseEntity<String> status() {

        String body = env.getProperty("spring.application.name") + " loaded from " + env.getProperty("app.environment.name");
        body += "\nDatabase driver: " + env.getProperty("app.database.driverClassname");
        body += "\nDatabase URL: " + env.getProperty("app.database.url");
        body += "\nDatabase Username: " + env.getProperty("app.database.username");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
