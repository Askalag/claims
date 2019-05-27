package com.askalag.claims.service;

import com.askalag.claims.entity.Role;

public interface RoleService {

    Role findByName (String name);
    void addRole(Role role);

}
