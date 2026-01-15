package com.java.from.scratch.interview.questions.q1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/test")
    public String test() {
        return appName;
    }
}