package com.zaggle.xpns.admin.authentication.web.rest;

import com.zaggle.xpns.admin.authentication.domain.User;
import com.zaggle.xpns.admin.authentication.service.dto.AuthDto;
import com.zaggle.xpns.admin.authentication.service.dto.UserApiDto;
import com.zaggle.xpns.admin.authentication.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RequestMapping(value = "/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostConstruct
    public void initRoleAndUser() {
        userServiceImpl.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody UserApiDto userApiDto) {
        return userServiceImpl.registerNewUser(userApiDto);
    }

    @GetMapping("/role")
    @PreAuthorize("hasRole(#authority)")
    public AuthDto forRole(@RequestParam String authority) {
        AuthDto authDto = new AuthDto();
        authDto.setRole(authority);
        return authDto;
    }
}