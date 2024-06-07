package com.example.salestracking.service;

import com.example.salestracking.dto.request.customer.CreateCustomerRequest;
import com.example.salestracking.dto.request.customer.UpdateCustomerRequest;
import com.example.salestracking.dto.response.customer.CreateCustomerResponse;
import com.example.salestracking.dto.response.customer.GetAllCustomersResponse;
import com.example.salestracking.dto.response.customer.GetCustomerResponse;
import com.example.salestracking.dto.response.customer.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    GetCustomerResponse getById(Long id);
    CreateCustomerResponse add(CreateCustomerRequest request);
    UpdateCustomerResponse update(Long id, UpdateCustomerRequest request);
    String delete(Long id);
}
