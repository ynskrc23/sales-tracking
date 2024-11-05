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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/salespersons")
public class SalespersonController
{
    private final SalespersonService service;

    @GetMapping
    public List<GetAllSalespersonsResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSalespersonResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSalespersonResponse add(@Valid @RequestBody CreateSalespersonRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSalespersonResponse update(@PathVariable Long id, @Valid @RequestBody UpdateSalespersonRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id)
    {
        return service.delete(id);
    }
}
