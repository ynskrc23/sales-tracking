package com.example.salestracking.dto.request.invoice;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInvoiceRequest {
    @NotNull(message = "Amount Due is mandatory")
    private double amountDue;

    @NotNull(message = "Status is mandatory")
    private String status;

    @NotNull(message = "Sale is mandatory")
    private int sale_id;
}
