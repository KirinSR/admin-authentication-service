package com.zaggle.xpns.admin.authentication.service.impl;

import com.zaggle.xpns.admin.authentication.domain.User;
import com.zaggle.xpns.admin.authentication.repository.RoleDao;
import com.zaggle.xpns.admin.authentication.repository.UserDao;
import com.zaggle.xpns.admin.authentication.domain.ERole;
import com.zaggle.xpns.admin.authentication.domain.Role;
import com.zaggle.xpns.admin.authentication.service.UserService;
import com.zaggle.xpns.admin.authentication.service.dto.UserApiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void initRoleAndUser() {
        // Check if role already exists in database
        ERole roleEnum = ERole.SUPER_ADMIN;
        Optional<Role> optionalRole = roleDao.findByName(roleEnum.name());
        if (!optionalRole.isPresent()) {
            // Create new role if not found
            Role role = new Role();
            role.setName(roleEnum.name());
            roleDao.save(role);
        }
        Role role = optionalRole.get();

        // Check if user already exists in database
        Optional<User> optionalUser = userDao.findByUserName("superAdminXpns");
        if (!optionalUser.isPresent()) {
            // Create new user if not found
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            User user = new User();
            user.setUserName("superAdminXpns");
            user.setUserFirstName("superAdmin");
            user.setUserLastName("Xpns");
            user.setEmail("superAdminXpns@yopmail.com");
            user.setMobileNumber("6000000100");
            user.setRoles(userRoles);
            user.setUserPassword(getEncodedPassword("Xpns@123"));
            user.setConfirmPassword(getEncodedPassword("Xpns@123"));
            userDao.save(user);
        }
    }


    @Override
    public User registerNewUser(UserApiDto userApiDto) {
        ERole roleEnum = ERole.valueOf(userApiDto.getRoleName().toUpperCase());
        Role role = roleDao.findByName(roleEnum.name()).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        User user = new User();
        user.setUserName(userApiDto.getUserName());
        user.setUserFirstName(userApiDto.getUserFirstName());
        user.setUserLastName(userApiDto.getUserLastName());
        user.setEmail(userApiDto.getEmail());
        user.setMobileNumber(userApiDto.getMobileNumber());
        user.setRoles(userRoles);
        user.setUserPassword(getEncodedPassword(userApiDto.getUserPassword()));
        user.setConfirmPassword(getEncodedPassword(userApiDto.getConfirmPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}