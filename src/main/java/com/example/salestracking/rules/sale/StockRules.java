package com.example.salestracking.rules.sale;

import com.example.salestracking.exception.InsufficientStockException;
import com.example.salestracking.exception.ProductNotFoundException;
import com.example.salestracking.model.Product;
import com.example.salestracking.model.Sale;
import com.example.salestracking.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public void reduceStock(Sale sale)
    {
        Optional<Product> isProduct = productRepository.findById((long) sale.getProduct().getId());
        if (isProduct.isPresent())
        {
            Product product = isProduct.get();
            int newStock = product.getStockQuantity() - sale.getQuantity();
            if (newStock >= 0)
            {
                product.setStockQuantity(newStock);
                productRepository.save(product);
            }
            else
            {
                try {
                    throw new InsufficientStockException("Insufficient stock: " + product.getName());
                } catch (InsufficientStockException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else
        {
            try {
                throw new ProductNotFoundException("Product not found.");
            } catch (ProductNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
