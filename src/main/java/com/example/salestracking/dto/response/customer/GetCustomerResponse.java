package com.example.salestracking.dto.response.customer;

import lombok.*;

@Data
public class GetCustomerResponse
{
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
}
