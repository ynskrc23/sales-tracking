package com.example.salestracking.repository;

import com.example.salestracking.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long>
{

}
