package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.menu.CreateMenuRequest;
import com.example.salestracking.model.Menu;
import com.example.salestracking.model.Role;
import com.example.salestracking.repository.MenuRepository;
import com.example.salestracking.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuManager implements MenuService
{
    private final MenuRepository repository;
    @Override
    public List<Menu> getAll()
    {
        List<Menu> menus = repository.findAll();
        return menus;
    }

    @Override
    public Menu getById(Long id)
    {
        Menu menu = repository.findById(id).orElseThrow();
        return menu;
    }

    @Override
    public Menu add(CreateMenuRequest request, boolean create, boolean update, boolean list)
    {
        // Dönüştürme işlemi
        Menu menu = new Menu();
        menu.setMenuName(request.getMenuName());
        menu.setMenuUrl("#");
        menu.setMenuIcon(request.getMenuIcon());
        menu.setMenuType(0);
        menu.setMenuParentId(0L);
        menu.setMenuOrder(request.getMenuOrder());
        menu.setMenuStatus(request.getMenuStatus());
        menu.setMenuVisible(true);
        Menu savedMenu = repository.save(menu);

        if (create)
        {
            // Handle create menu
            Menu createMenu = new Menu();
            createMenu.setMenuName(request.getMenuName() + " Add");
            createMenu.setMenuUrl(request.getMenuName() + "Form.js");
            createMenu.setMenuIcon(request.getMenuIcon());
            createMenu.setMenuOrder(2);
            createMenu.setMenuStatus(true);
            createMenu.setMenuType(2);
            createMenu.setMenuParentId(savedMenu.getMenuId());
            createMenu.setMenuVisible(true);
            repository.save(createMenu);
        }

        if (update)
        {
            // Handle update menu
            Menu updateMenu = new Menu();
            updateMenu.setMenuName(request.getMenuName() + " Edit");
            updateMenu.setMenuUrl(request.getMenuName() + "Form.js");
            updateMenu.setMenuIcon(request.getMenuIcon());
            updateMenu.setMenuOrder(3);
            updateMenu.setMenuStatus(true);
            updateMenu.setMenuType(3);
            updateMenu.setMenuParentId(savedMenu.getMenuId());
            updateMenu.setMenuVisible(true);
            repository.save(updateMenu);
        }

        if (list)
        {
            // Handle list menu
            Menu listMenu = new Menu();
            listMenu.setMenuName(request.getMenuName() + " List");
            listMenu.setMenuUrl(request.getMenuName() + "List.js");
            listMenu.setMenuIcon(request.getMenuIcon());
            listMenu.setMenuOrder(1);
            listMenu.setMenuStatus(true);
            listMenu.setMenuType(1);
            listMenu.setMenuParentId(savedMenu.getMenuId());
            listMenu.setMenuVisible(true);
            repository.save(listMenu);
        }

        return savedMenu;
    }

    @Override
    public String delete(Long id)
    {
        // Ana menüyü bul
        Menu menu = repository.findById(id).orElseThrow();

        // menuParentId'si ana menüye eşit olan tüm alt menüleri bul ve sil
        List<Menu> subMenus = repository.findByMenuParentId(menu.getMenuId());
        if (!subMenus.isEmpty()) {
            repository.deleteAll(subMenus);
        }

        // Ana menüyü sil
        repository.delete(menu);
        return "Menu deleted successfully";
    }
}
