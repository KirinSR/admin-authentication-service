package com.zaggle.xpns.admin.authentication.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseApiDto {
    private String userName;
    private String mobileNumber;
    private String email;
    private String userFirstName;
    private String userLastName;
    private String roleName;
}