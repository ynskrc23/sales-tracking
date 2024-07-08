package com.example.salestracking.dto.request.sale;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSaleRequest {
    @Min(1)
    @NotNull(message = "Stock is mandatory")
    private int quantity;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Sale Number is not null")
    private String saleNumber;

    @NotNull(message = "Customer is mandatory")
    private int customer_id;

    @NotNull(message = "Product is mandatory")
    private int product_id;
}
