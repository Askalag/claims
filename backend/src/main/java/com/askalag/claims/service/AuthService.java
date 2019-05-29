package com.askalag.claims.service;

import com.askalag.claims.model.LoginForm;
import com.askalag.claims.model.RegisterForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(LoginForm form);
    ResponseEntity<?> register(RegisterForm form);
}
