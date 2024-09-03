package com.example.salestracking.repository;

import com.example.salestracking.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>
{

}
