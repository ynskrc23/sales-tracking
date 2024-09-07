package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "role_permission", nullable = false)
    private String rolePermission;

    @Column(name = "role_status")
    private Boolean roleStatus;
}
