package com.example.salestracking.dto.response.invoice;

import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllInvoicesResponse {
    private Long id;
    private double amountDue;
    private String status;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime invoiceDate;
    private GetAllSalesResponse sale;
}
