package com.askalag.claims.security.service;

import com.askalag.claims.security.model.JwtResponse;
import com.askalag.claims.security.model.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterService {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder encoder;

    public JwtResponse register(@RequestBody RegisterForm form) {
        return null;
    }
}
