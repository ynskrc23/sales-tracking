package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// code first
@Entity // not needed but it's useful for reviewing
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales")
public class Sale extends BaseEntity {
    private int quantity;
    private BigDecimal productSalePrice;
    private BigDecimal totalAmount;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
