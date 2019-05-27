package com.askalag.claims.security.service;

import com.askalag.claims.entity.Role;
import com.askalag.claims.entity.User;
import com.askalag.claims.security.CustomUserDetails;
import com.askalag.claims.security.JwtAuthProvider;
import com.askalag.claims.security.model.JwtResponse;
import com.askalag.claims.security.model.LoginForm;
import com.askalag.claims.security.model.RegisterForm;
import com.askalag.claims.security.model.ResponseMessage;
import com.askalag.claims.service.RoleService;
import com.askalag.claims.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtAuthProvider jwtAuthProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<?> login(LoginForm form) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtAuthProvider.generateJwtToken(authentication);
        CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();

        return new ResponseEntity<>(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities()), HttpStatus.OK);
    }

    public ResponseEntity<?> register(RegisterForm form) {

        if (form == null || userService.existsByEmail(form.getEmail()) || userService.existsByUsername(form.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("0002", "Username or email are already exist"), HttpStatus.BAD_REQUEST);
        }

        Role role = roleService.findByName("role_user");

        List<Role> roles = new LinkedList<>();
        roles.add(role);

        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));
        user.setRoles(roles);

        userService.addUser(user);

        return new ResponseEntity<>(new ResponseMessage("0200", "User is registered successfully!"), HttpStatus.OK);
    }
}
