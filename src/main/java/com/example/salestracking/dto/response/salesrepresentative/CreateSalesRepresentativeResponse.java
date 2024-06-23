package com.example.salestracking.dto.response.salesrepresentative;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSalesRepresentativeResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
