package com.example.salestracking.controller;

import com.example.salestracking.dto.request.menu.CreateMenuRequest;
import com.example.salestracking.model.Menu;
import com.example.salestracking.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/menus")
public class MenuController
{
    private final MenuService service;

    @GetMapping
    public List<Menu> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Menu getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Menu add(@RequestBody CreateMenuRequest request, boolean create, boolean update, boolean list)
    {
        return service.add(request,create,update,list);
    }
}
