package com.xy.test.test.service;

import com.xy.test.test.Repository.UserRepository;
import com.xy.test.test.entity.RoleEntity;
import com.xy.test.test.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findAllByUsername(s);
    }

    public UserEntity saveUser(UserEntity userEntity){
        RoleEntity role = roleService.findRoleByName("USER");
        HashSet<RoleEntity> set = new HashSet<>();
        set.add(role);
        userEntity.setRoleEntities(set);

        return userRepository.save(userEntity);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity getUserByUsername(String name) {
        return userRepository.findAllByUsername(name);
    }
}
