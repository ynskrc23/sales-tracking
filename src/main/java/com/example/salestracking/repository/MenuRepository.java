package com.example.salestracking.repository;

import com.example.salestracking.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long>
{
    // Alt menüleri bulmak için
    List<Menu> findByMenuParentId(Long menuParentId);
}
