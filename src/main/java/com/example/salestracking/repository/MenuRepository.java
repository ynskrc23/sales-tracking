package com.example.salestracking.repository;

import com.example.salestracking.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>
{
}
