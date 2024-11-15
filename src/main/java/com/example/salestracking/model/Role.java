package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
