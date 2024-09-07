package com.example.salestracking.service;

import com.example.salestracking.dto.request.menu.CreateMenuRequest;
import com.example.salestracking.model.Menu;
import java.util.List;

public interface MenuService
{
    List<Menu> getAll();
    Menu getById(Long id);
    Menu add(CreateMenuRequest request, boolean create, boolean update, boolean list);
    String delete(Long id);
}
