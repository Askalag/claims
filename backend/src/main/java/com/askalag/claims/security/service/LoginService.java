package com.askalag.claims.security.service;

import com.askalag.claims.security.CustomUserDetails;
import com.askalag.claims.security.JwtAuthProvider;
import com.askalag.claims.security.model.JwtResponse;
import com.askalag.claims.security.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtAuthProvider jwtAuthProvider;

    public JwtResponse login(LoginForm form) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtAuthProvider.generateJwtToken(authentication);
        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();

        return new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities());
    }
}
