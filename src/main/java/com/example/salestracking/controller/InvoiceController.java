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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoices")
public class InvoiceController extends BaseController
{
    private final InvoiceService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllInvoicesResponse> invoices = service.getAll();
            return jsonResponse(invoices, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id)
    {
        try {
            GetInvoiceResponse invoice = service.getById(id);
            return jsonResponse(invoice, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Invoice not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateInvoiceRequest request)
    {
        try {
            CreateInvoiceResponse invoice = service.add(request);
            return jsonResponse(invoice, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UpdateInvoiceRequest request)
    {
        try {
            UpdateInvoiceResponse invoice = service.update(id, request);
            return jsonResponse(invoice, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to update invoice for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id)
    {
        try {
            service.delete(id);
            return jsonResponse("Invoice deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete invoice for ID: " + id));
        }
    }
}
