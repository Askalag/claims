package com.askalag.claims.controller;

import com.askalag.claims.security.model.JwtResponse;
import com.askalag.claims.security.model.LoginForm;
import com.askalag.claims.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginService loginService;

    PasswordEncoder encoder;

    @GetMapping("/test")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginForm form) {

        return loginService.login(form);
    }


}
