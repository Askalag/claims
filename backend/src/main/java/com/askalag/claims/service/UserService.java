package com.askalag.claims.service;

import com.askalag.claims.entity.User;

public interface UserService {

    void addUser(User user);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
