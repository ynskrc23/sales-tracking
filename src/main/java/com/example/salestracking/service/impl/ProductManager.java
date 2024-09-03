package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.product.CreateProductRequest;
import com.example.salestracking.dto.request.product.UpdateProductRequest;
import com.example.salestracking.dto.response.product.CreateProductResponse;
import com.example.salestracking.dto.response.product.GetAllProductsResponse;
import com.example.salestracking.dto.response.product.GetProductResponse;
import com.example.salestracking.dto.response.product.UpdateProductResponse;
import com.example.salestracking.model.Product;
import com.example.salestracking.repository.ProductRepository;
import com.example.salestracking.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllProductsResponse> getAll()
    {
        List<Product> products = repository.findAll();
        return products.stream().map(product -> mapper.map(product, GetAllProductsResponse.class)).toList();
    }

    @Override
    public GetProductResponse getById(Long id)
    {
        Product product = repository.findById(id).orElseThrow(null);
        return mapper.map(product, GetProductResponse.class);
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request)
    {
        Product product = mapper.map(request, Product.class);
        product.setProductId(0L);
        repository.save(product);
        return mapper.map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(Long id, UpdateProductRequest request)
    {
        Optional<Product> isProduct = repository.findById(id);
        if(isProduct.isPresent())
        {
            Product product = mapper.map(request, Product.class);
            product.setProductId((long) Math.toIntExact(id));
            repository.save(product);
            return mapper.map(product, UpdateProductResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Long id)
    {
        Optional<Product> isProduct = repository.findById(id);
        if(isProduct.isPresent())
        {
            repository.deleteById(id);
            return "Product deleted successfully";
        }
        return "No such product in the database";
    }
}
