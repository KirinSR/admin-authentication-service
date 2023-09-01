package com.zaggle.xpns.admin.authentication.service.impl;

import com.zaggle.xpns.admin.authentication.domain.ERole;
import com.zaggle.xpns.admin.authentication.domain.Role;
import com.zaggle.xpns.admin.authentication.repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl {

    @Autowired
    private RoleDao roleDao;

    public void initRoleAndUser() {
        createRoleIfNotExist(ERole.ADMIN);
        createRoleIfNotExist(ERole.SUPER_ADMIN);
        createRoleIfNotExist(ERole.CUSTOMER_SUPPORT_ADMIN);
        createRoleIfNotExist(ERole.FINANCE_ADMIN);
        createRoleIfNotExist(ERole.CUSTOMER_SUPPORT);
        createRoleIfNotExist(ERole.FINANCE_TEAM_MEMBER);
        createRoleIfNotExist(ERole.SALES_TEAM_MANAGER);
        createRoleIfNotExist(ERole.SALES_MANAGER);
    }

    private void createRoleIfNotExist(ERole eRole) {
        Optional<Role> optionalRole = roleDao.findByName(eRole.name());
        if (optionalRole.isPresent()) {
            return;
        }
        Role role = new Role();
        role.setName(eRole.name());
        roleDao.save(role);
    }

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
