package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "fullname", nullable = false, length = 50)
    private String fullName;

    @Column(name = "email",nullable = false, length = 100)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_order")
    private Integer userOrder;

    @Column(name = "user_status")
    private Boolean userStatus;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private Role role;
}
