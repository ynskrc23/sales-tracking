package com.example.salestracking.service;

import com.example.salestracking.dto.request.salesperson.CreateSalespersonRequest;
import com.example.salestracking.dto.request.salesperson.UpdateSalespersonRequest;
import com.example.salestracking.dto.response.salesperson.CreateSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.GetAllSalespersonsResponse;
import com.example.salestracking.dto.response.salesperson.GetSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.UpdateSalespersonResponse;

import java.util.List;

public interface SalespersonService
{
    List<GetAllSalespersonsResponse> getAll();
    GetSalespersonResponse getById(Long id);
    CreateSalespersonResponse add(CreateSalespersonRequest request);
    UpdateSalespersonResponse update(Long id, UpdateSalespersonRequest request);
    String delete(Long id);
}
