package com.example.salestracking.dto.request.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest
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
}
