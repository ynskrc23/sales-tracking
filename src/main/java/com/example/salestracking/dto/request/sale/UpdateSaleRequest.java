package com.example.salestracking.dto.request.sale;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
    @Min(1)
    @NotNull(message = "Stock is mandatory")
    private int quantity;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Customer is mandatory")
    private int customer_id;

    @NotNull(message = "Product is mandatory")
    private int product_id;
}
