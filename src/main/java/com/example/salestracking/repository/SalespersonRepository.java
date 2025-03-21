package com.example.salestracking.repository;

import com.example.salestracking.model.Salesperson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalespersonRepository extends JpaRepository<Salesperson, Long>
{

}
