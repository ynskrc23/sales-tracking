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
@Table(name = "salesPipelines")
public class SalesPipeline extends BaseEntity{
    private String stage;
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;
}
