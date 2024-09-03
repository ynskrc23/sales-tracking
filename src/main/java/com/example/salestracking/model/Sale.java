package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sales")
@Data
public class Sale extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    @Column(name = "sale_date", nullable = false)
    private LocalDate saleDate;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "sale")
    private Set<SaleItem> saleItems;

    @OneToOne(mappedBy = "sale")
    private Invoice invoice;
}