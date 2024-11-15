package com.example.salestracking.dto.response.user;

import com.example.salestracking.dto.response.role.GetRoleResponse;
import lombok.Data;

@Data
public class CreateUserResponse
{
    private Long userId;
    private String fullName;
    private String email;
    private String password;
    private Integer userOrder;
    private Boolean userStatus;
    private GetRoleResponse role;
}
