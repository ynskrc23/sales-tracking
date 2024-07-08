package com.example.salestracking.repository;

import com.example.salestracking.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findBySaleNumber(String saleNumber);
    @Query("SELECT s.saleNumber, " +
            "       SUM(s.quantity) AS totalQuantity, " +
            "       SUM(s.totalAmount) AS totalAmount, " +
            "       c, " +
            "       p " +
            "FROM Sale s " +
            "JOIN s.customer c " +
            "JOIN s.product p " +
            "GROUP BY s.saleNumber, c.id, p.id")
    List<Object[]> countSalesBySaleNumber();

}
