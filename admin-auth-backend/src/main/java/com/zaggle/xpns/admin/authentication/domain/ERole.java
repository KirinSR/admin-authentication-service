package com.zaggle.xpns.admin.authentication.domain;

public enum ERole {

    SUPER_ADMIN, //Only one in count - 2FA,
    ADMIN , //    - no limit - 2FA
    CUSTOMER_SUPPORT_ADMIN , // - No limit - 2FA
    CUSTOMER_SUPPORT,
    FINANCE_ADMIN, // - 2FA
    FINANCE_TEAM_MEMBER,
    SALES_MANAGER, // 
    SALES_TEAM_MANAGER
}
