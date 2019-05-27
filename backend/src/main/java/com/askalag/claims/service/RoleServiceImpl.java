package com.askalag.claims.service;

import com.askalag.claims.entity.Role;
import com.askalag.claims.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void addRole(Role role) {
        roleRepository.saveAndFlush(role);
    }

}
