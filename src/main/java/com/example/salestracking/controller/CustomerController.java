package com.example.salestracking.controller;

import com.example.salestracking.dto.request.customer.CreateCustomerRequest;
import com.example.salestracking.dto.request.customer.UpdateCustomerRequest;
import com.example.salestracking.dto.response.customer.CreateCustomerResponse;
import com.example.salestracking.dto.response.customer.GetAllCustomersResponse;
import com.example.salestracking.dto.response.customer.GetCustomerResponse;
import com.example.salestracking.dto.response.customer.UpdateCustomerResponse;
import com.example.salestracking.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse add(@Valid @RequestBody CreateCustomerRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCustomerResponse update(@PathVariable Long id, @Valid @RequestBody UpdateCustomerRequest request)
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
