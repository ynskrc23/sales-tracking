package com.example.salestracking.dto.response.invoice;

import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateInvoiceResponse {
    private Long id;
    private double amountDue;
    private String status;
    private LocalDateTime invoiceDate;
    private GetAllSalesResponse sale;
}
