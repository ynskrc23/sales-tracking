package com.example.salestracking.service;

import com.example.salestracking.dto.request.category.CreateCategoryRequest;
import com.example.salestracking.dto.request.category.UpdateCategoryRequest;
import com.example.salestracking.dto.response.category.GetAllCategoriesResponse;
import com.example.salestracking.dto.response.category.GetCategoryResponse;
import com.example.salestracking.dto.response.category.CreateCategoryResponse;
import com.example.salestracking.dto.response.category.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService
{
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(Long id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(Long id, UpdateCategoryRequest request);
    String delete(Long id);
}
