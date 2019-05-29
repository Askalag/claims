package com.askalag.claims.controller;

import com.askalag.claims.model.LoginForm;
import com.askalag.claims.model.RegisterForm;
import com.askalag.claims.service.AuthService;
import com.askalag.claims.service.LoginService;
import com.askalag.claims.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    LoginService loginService;
    @Autowired
    RegisterService registerService;
    @Autowired
    AuthService authService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form) {
        return authService.login(form);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterForm form) {
        return authService.register(form);
    }
}
