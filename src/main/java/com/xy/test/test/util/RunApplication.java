package com.xy.test.test.util;

import com.xy.test.test.entity.RoleEntity;
import com.xy.test.test.entity.UserEntity;
import com.xy.test.test.service.RoleService;
import com.xy.test.test.service.UserService;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class RunApplication implements ApplicationRunner {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RoleEntity role = new RoleEntity();
        role.setName("USER");

        roleService.saveRole(role);

        UserEntity user = new UserEntity();
        user.setId("1ac9c035-b655-46c8-b187-de08a1ba6b2b");
        user.setUsername("xytest");
        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        HashSet<RoleEntity> set = new HashSet<>();
        set.add(role);
        user.setRoleEntities(set);

        userService.saveUser(user);



    }
}
