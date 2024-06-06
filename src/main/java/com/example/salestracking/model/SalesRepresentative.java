package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// code first
@Entity // not needed but it's useful for reviewing
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salesRepresentatives")
public class SalesRepresentative extends BaseEntity{
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
