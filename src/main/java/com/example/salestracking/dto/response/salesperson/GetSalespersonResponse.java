package com.example.salestracking.dto.response.salesperson;

import lombok.Data;

@Data
public class GetSalespersonResponse
{
    private Long salespersonId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private java.time.LocalDate hireDate;
}
