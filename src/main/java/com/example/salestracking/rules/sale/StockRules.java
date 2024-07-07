package com.example.salestracking.rules.sale;

import com.example.salestracking.exception.InsufficientStockException;
import com.example.salestracking.model.Product;
import com.example.salestracking.model.Sale;
import com.example.salestracking.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockRules {

    private final ProductRepository productRepository;

    @Autowired
    public StockRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void checkStock(Sale sale)
    {
        Product product = productRepository.findById((long) sale.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (sale.getQuantity() > product.getStockQuantity())
        {
            try {
                throw new InsufficientStockException("Insufficient stock for product: " + product.getName());
            } catch (InsufficientStockException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
