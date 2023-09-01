package com.zaggle.xpns.admin.authentication.service;

import com.zaggle.xpns.admin.authentication.domain.User;
import com.zaggle.xpns.admin.authentication.service.dto.UserApiDto;

public interface UserService {
    void initRoleAndUser();

    User registerNewUser(UserApiDto userApiDto);
}
