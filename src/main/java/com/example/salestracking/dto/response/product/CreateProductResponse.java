package com.example.salestracking.dto.response.product;

import com.example.salestracking.dto.response.category.GetAllCategoriesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductResponse
{
    private Long productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private GetAllCategoriesResponse category;
}
