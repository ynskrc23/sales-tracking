package com.example.salestracking.dto.response.product;

import com.example.salestracking.dto.response.category.GetAllCategoriesResponse;
import lombok.*;

import java.math.BigDecimal;

@Data
public class GetProductResponse
{
    private Long productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private GetAllCategoriesResponse category;
}
