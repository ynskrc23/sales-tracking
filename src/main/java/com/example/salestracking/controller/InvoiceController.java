package com.example.salestracking.controller;

import com.example.salestracking.dto.request.invoice.CreateInvoiceRequest;
import com.example.salestracking.dto.request.invoice.UpdateInvoiceRequest;
import com.example.salestracking.dto.response.invoice.CreateInvoiceResponse;
import com.example.salestracking.dto.response.invoice.GetAllInvoicesResponse;
import com.example.salestracking.dto.response.invoice.GetInvoiceResponse;
import com.example.salestracking.dto.response.invoice.UpdateInvoiceResponse;
import com.example.salestracking.service.InvoiceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceController
{
    private final InvoiceService service;
    @GetMapping
    public List<GetAllInvoicesResponse> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetInvoiceResponse getById(@PathVariable Integer id)
    {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateInvoiceResponse add(@Valid @RequestBody CreateInvoiceRequest request)
    {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateInvoiceResponse update(@PathVariable Integer id, @Valid @RequestBody UpdateInvoiceRequest request)
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
