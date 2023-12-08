package com.example.dbdemo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/hi")
    public String dummy() {
        return "{\"message\":\"Hi!\"}";
    }
}
