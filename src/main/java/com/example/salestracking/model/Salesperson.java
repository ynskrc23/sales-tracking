package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Entity
@Table(name = "salespersons")
@Data
public class Salesperson extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salespersonId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "hire_date")
    private java.time.LocalDate hireDate;
}