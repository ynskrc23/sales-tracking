package com.example.salestracking.service;

import com.example.salestracking.dto.request.salesrepresentative.CreateSalesRepresentativeRequest;
import com.example.salestracking.dto.request.salesrepresentative.UpdateSalesRepresentativeRequest;
import com.example.salestracking.dto.response.salesrepresentative.CreateSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetAllSalesRepresentativesResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.UpdateSalesRepresentativeResponse;

import java.util.List;

public interface SalesRepresentativeService {
    List<GetAllSalesRepresentativesResponse> getAll();
    GetSalesRepresentativeResponse getById(Integer id);
    CreateSalesRepresentativeResponse add(CreateSalesRepresentativeRequest request);
    UpdateSalesRepresentativeResponse update(Integer id, UpdateSalesRepresentativeRequest request);
    String delete(Integer id);
}
