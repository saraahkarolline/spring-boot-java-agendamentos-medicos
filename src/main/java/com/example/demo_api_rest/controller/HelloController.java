package com.example.demo_api_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String olaMundo() {
        return "Hello World Spring Teste!";
    }

    

}
