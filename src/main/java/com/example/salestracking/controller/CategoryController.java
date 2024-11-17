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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController extends BaseController
{
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllCategoriesResponse> categories = service.getAll();
            return jsonResponse(categories, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetCategoryResponse category = service.getById(id);
            return jsonResponse(category, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Category not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateCategoryRequest request)
    {
        try {
            CreateCategoryResponse category = service.add(request);
            return jsonResponse(category, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateCategoryRequest request)
    {
        try {
            UpdateCategoryResponse category = service.update(id, request);
            return jsonResponse(category, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to update category for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Kategori silme başarılı.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete category for ID: " + id));
        }
    }
}
