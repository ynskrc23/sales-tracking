package com.example.salestracking.controller;

import com.example.salestracking.dto.request.product.CreateProductRequest;
import com.example.salestracking.dto.request.product.UpdateProductRequest;
import com.example.salestracking.dto.response.product.CreateProductResponse;
import com.example.salestracking.dto.response.product.GetAllProductsResponse;
import com.example.salestracking.dto.response.product.GetProductResponse;
import com.example.salestracking.dto.response.product.UpdateProductResponse;
import com.example.salestracking.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@Valid @RequestBody CreateProductRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request)
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
