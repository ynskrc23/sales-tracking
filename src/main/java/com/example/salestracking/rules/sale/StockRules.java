package com.example.salestracking.rules.sale;

import com.example.salestracking.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockRules
{
    private final ProductRepository productRepository;

    @Autowired
    public StockRules(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
}
