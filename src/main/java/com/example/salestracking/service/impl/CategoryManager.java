package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.category.CreateCategoryRequest;
import com.example.salestracking.dto.request.category.UpdateCategoryRequest;
import com.example.salestracking.dto.response.category.CreateCategoryResponse;
import com.example.salestracking.dto.response.category.GetAllCategoriesResponse;
import com.example.salestracking.dto.response.category.GetCategoryResponse;
import com.example.salestracking.dto.response.category.UpdateCategoryResponse;
import com.example.salestracking.model.Category;
import com.example.salestracking.repository.CategoryRepository;
import com.example.salestracking.service.CategoryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService
{
    private final CategoryRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCategoriesResponse> getAll()
    {
        List<Category> categories = repository.findAll();
        return categories.stream().map(category -> mapper.map(category, GetAllCategoriesResponse.class)).toList();
    }

    @Override
    public GetCategoryResponse getById(Long id)
    {
        Category category = repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return mapper.map(category, GetCategoryResponse.class);
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request)
    {
        Category category = mapper.map(request, Category.class);
        category.setCategoryId(0L);
        repository.save(category);
        return mapper.map(category, CreateCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse update(Long id, UpdateCategoryRequest request)
    {
        Optional<Category> isCategory = repository.findById(id);
        if(isCategory.isPresent())
        {
            Category category = mapper.map(request, Category.class);
            category.setCategoryId((long) Math.toIntExact(id));
            repository.save(category);
            return mapper.map(category, UpdateCategoryResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Long id)
    {
        Optional<Category> isCategory = repository.findById(id);
        if(isCategory.isPresent())
        {
            repository.deleteById(id);
            return "Category deleted successfully";
        }
        return "No such category in the database";
    }
}
