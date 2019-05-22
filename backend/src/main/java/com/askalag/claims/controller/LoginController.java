package com.askalag.claims.controller;

import com.askalag.claims.security.model.LoginForm;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/login")
public class LoginController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @PostMapping
    public String login(@RequestBody LoginForm form) {
        return null;
    }

}
