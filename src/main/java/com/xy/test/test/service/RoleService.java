package com.xy.test.test.service;

import com.xy.test.test.Repository.RoleRepository;
import com.xy.test.test.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity saveRole(RoleEntity roleEntity){
        return roleRepository.save(roleEntity);
    }

    public RoleEntity findRoleByName(String name){
        return roleRepository.findAllByName(name);
    }
}
