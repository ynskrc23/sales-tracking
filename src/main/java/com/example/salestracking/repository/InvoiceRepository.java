package com.example.salestracking.repository;

import com.example.salestracking.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{

}
