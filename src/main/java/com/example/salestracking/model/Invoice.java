package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
// code first
@Entity // not needed but it's useful for reviewing
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
    private double amountDue;
    private String status;
    private LocalDateTime invoiceDate = LocalDateTime.now();
}
