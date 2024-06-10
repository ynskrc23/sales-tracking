package com.example.salestracking.controller;

import com.example.salestracking.dto.request.sale.CreateSaleRequest;
import com.example.salestracking.dto.request.sale.UpdateSaleRequest;
import com.example.salestracking.dto.response.sale.CreateSaleResponse;
import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import com.example.salestracking.dto.response.sale.GetSaleResponse;
import com.example.salestracking.dto.response.sale.UpdateSaleResponse;
import com.example.salestracking.service.SaleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SaleController {
    private final SaleService service;

    @GetMapping
    public List<GetAllSalesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSaleResponse getById(@PathVariable Integer id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSaleResponse add(@Valid @RequestBody CreateSaleRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSaleResponse update(@PathVariable Integer id, @Valid @RequestBody UpdateSaleRequest request)
    {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Integer id)
    {
        return service.delete(id);
    }
}
