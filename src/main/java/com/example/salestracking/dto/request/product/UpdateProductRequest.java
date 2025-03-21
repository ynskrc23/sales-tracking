package com.example.salestracking.dto.request.product;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest
{
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String productName;

    private String description;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @Min(1)
    @NotNull(message = "Stock is mandatory")
    private int stockQuantity;

    @NotNull(message = "Category is mandatory")
    private int categoryId;
}
