package com.example.salestracking.dto.response.sale;

import com.example.salestracking.dto.response.customer.GetAllCustomersResponse;
import com.example.salestracking.dto.response.product.GetAllProductsResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSaleResponse {
    private Long id;
    private int quantity;
    private double productSalePrice;
    private double totalAmount;
    private String status;
    private GetAllCustomersResponse customer;
    private GetAllProductsResponse product;
}
