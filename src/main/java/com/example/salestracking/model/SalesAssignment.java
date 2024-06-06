package com.example.salestracking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// code first
@Entity // not needed but it's useful for reviewing
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "salesAssignments")
public class SalesAssignment extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "sales_representative_id")
    private SalesRepresentative salesRepresentative;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
