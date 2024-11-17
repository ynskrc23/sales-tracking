package com.example.salestracking.controller;

import com.example.salestracking.dto.request.salesperson.CreateSalespersonRequest;
import com.example.salestracking.dto.request.salesperson.UpdateSalespersonRequest;
import com.example.salestracking.dto.response.salesperson.CreateSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.GetAllSalespersonsResponse;
import com.example.salestracking.dto.response.salesperson.GetSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.UpdateSalespersonResponse;
import com.example.salestracking.service.SalespersonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/salespersons")
public class SalespersonController extends BaseController
{
    private final SalespersonService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllSalespersonsResponse> salespersons = service.getAll();
            return jsonResponse(salespersons, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetSalespersonResponse salesperson = service.getById(id);
            return jsonResponse(salesperson, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Salesperson not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateSalespersonRequest request)
    {
        try {
            CreateSalespersonResponse salesperson = service.add(request);
            return jsonResponse(salesperson, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateSalespersonRequest request)
    {
        try {
            UpdateSalespersonResponse salesperson = service.update(id, request);
            return jsonResponse(salesperson, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Salesperson not found for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Salesperson deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete salesperson for ID: " + id));
        }
    }
}
