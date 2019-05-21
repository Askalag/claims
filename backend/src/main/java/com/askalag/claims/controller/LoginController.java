package com.askalag.claims.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
