package com.askalag.claims.security.service;

import com.askalag.claims.security.model.LoginForm;
import com.askalag.claims.security.model.RegisterForm;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> login(LoginForm form);
    ResponseEntity<?> register(RegisterForm form);
}
