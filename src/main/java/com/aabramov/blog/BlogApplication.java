package com.aabramov.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BlogApplication {
    
    @GetMapping(path = "/name")
    public String name() {
        return "Andrii";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    
    
}
