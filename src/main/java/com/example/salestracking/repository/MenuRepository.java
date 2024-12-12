package com.example.salestracking.repository;

import com.example.salestracking.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>
{
    // Alt menüleri bulmak için
    List<Menu> findByMenuParentId(Long menuParentId);
}
