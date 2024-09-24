package com.example.salestracking.service;

import com.example.salestracking.dto.request.product.CreateProductRequest;
import com.example.salestracking.dto.request.product.UpdateProductRequest;
import com.example.salestracking.dto.response.product.CreateProductResponse;
import com.example.salestracking.dto.response.product.GetAllProductsResponse;
import com.example.salestracking.dto.response.product.GetProductResponse;
import com.example.salestracking.dto.response.product.UpdateProductResponse;

import java.util.List;

public interface ProductService
{
    List<GetAllProductsResponse> getAll();
    GetProductResponse getById(Long id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(Long id, UpdateProductRequest request);
    String delete(Long id);
}
