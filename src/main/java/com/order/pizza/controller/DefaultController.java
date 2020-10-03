package com.order.pizza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "The Application is running!";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World!";
    }

}