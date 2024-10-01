package com.example.salestracking.controller;

import com.example.salestracking.dto.request.category.CreateCategoryRequest;
import com.example.salestracking.dto.request.category.UpdateCategoryRequest;
import com.example.salestracking.dto.response.category.CreateCategoryResponse;
import com.example.salestracking.dto.response.category.GetAllCategoriesResponse;
import com.example.salestracking.dto.response.category.GetCategoryResponse;
import com.example.salestracking.dto.response.category.UpdateCategoryResponse;
import com.example.salestracking.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController 
{
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id)
    {
        return service.delete(id);
    }
}
