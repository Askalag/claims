package com.askalag.claims.security.service;

import com.askalag.claims.security.CustomUserDetails;
import com.askalag.claims.security.JwtAuthProvider;
import com.askalag.claims.security.model.JwtResponse;
import com.askalag.claims.security.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


}
