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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController extends BaseController
{
    private final ProductService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllProductsResponse> products = service.getAll();
            return jsonResponse(products, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetProductResponse product = service.getById(id);
            return jsonResponse(product, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Product not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateProductRequest request)
    {
        try {
            CreateProductResponse product = service.add(request);
            return jsonResponse(product, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest request)
    {
        try {
            UpdateProductResponse product = service.update(id, request);
            return jsonResponse(product, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Product not found for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Product deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete product for ID: " + id));
        }
    }
}

