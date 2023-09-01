package com.zaggle.xpns.admin.authentication.web.rest;

import com.zaggle.xpns.admin.authentication.domain.Role;
import com.zaggle.xpns.admin.authentication.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @PostConstruct
    public void initRoleAndUser() {
        roleServiceImpl.initRoleAndUser();
    }

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleServiceImpl.createNewRole(role);
    }
}
