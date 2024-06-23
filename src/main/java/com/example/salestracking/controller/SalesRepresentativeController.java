package com.example.salestracking.controller;

import com.example.salestracking.dto.request.salesrepresentative.CreateSalesRepresentativeRequest;
import com.example.salestracking.dto.request.salesrepresentative.UpdateSalesRepresentativeRequest;
import com.example.salestracking.dto.response.salesrepresentative.CreateSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetAllSalesRepresentativesResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.UpdateSalesRepresentativeResponse;
import com.example.salestracking.service.SalesRepresentativeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/salesrepresentatives")
public class SalesRepresentativeController {
    private final SalesRepresentativeService service;

    @GetMapping
    public List<GetAllSalesRepresentativesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSalesRepresentativeResponse getById(@PathVariable Long id)
    {
        return service.getById(Math.toIntExact(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSalesRepresentativeResponse add(@Valid @RequestBody CreateSalesRepresentativeRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateSalesRepresentativeResponse update(@PathVariable Long id, @Valid @RequestBody UpdateSalesRepresentativeRequest request)
    {
        return service.update(Math.toIntExact(id), request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable Long id)
    {
        return service.delete(Math.toIntExact(id));
    }
}
