package com.askalag.claims.security.service;

import com.askalag.claims.repository.UserRepository;
import com.askalag.claims.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return CustomUserDetails.build(userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with username \"" + username + "\" not found" )
                )
        );
    }
}
