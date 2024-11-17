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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController extends BaseController
{
    private final CustomerService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllCustomersResponse> customers = service.getAll();
            return jsonResponse(customers, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        try {
            GetCustomerResponse customer = service.getById(id);
            return jsonResponse(customer, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Customer not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateCustomerRequest request)
    {
        try {
            CreateCustomerResponse customer = service.add(request);
            return jsonResponse(customer, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateCustomerRequest request)
    {
        try {
            UpdateCustomerResponse customer = service.update(id, request);
            return jsonResponse(customer, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to update customer for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        try {
            service.delete(id);
            return jsonResponse("Customer deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete customer for ID: " + id));
        }
    }
}
