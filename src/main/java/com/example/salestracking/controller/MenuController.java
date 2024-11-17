package com.example.salestracking.controller;

import com.example.salestracking.dto.request.menu.CreateMenuRequest;
import com.example.salestracking.model.Menu;
import com.example.salestracking.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/menus")
public class MenuController extends BaseController
{
    private final MenuService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<Menu> menus = service.getAll();
            return jsonResponse(menus, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            Menu menu = service.getById(id);
            return jsonResponse(menu, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Menu not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@RequestBody CreateMenuRequest request, boolean create, boolean update, boolean list)
    {
        try {
            Menu menu = service.add(request, create, update, list);
            return jsonResponse(menu, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Menu deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete menu for ID: " + id));
        }
    }
}
