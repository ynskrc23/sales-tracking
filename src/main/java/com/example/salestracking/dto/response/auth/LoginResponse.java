package com.example.salestracking.dto.response.auth;

import com.example.salestracking.dto.response.role.GetRoleResponse;
import lombok.Data;

@Data
public class LoginResponse
{
    private Long userId;
    private String fullName;
    private String email;
    private String password;
    private Integer userOrder;
    private Boolean userStatus;
    private GetRoleResponse role;
    private String token;
}
