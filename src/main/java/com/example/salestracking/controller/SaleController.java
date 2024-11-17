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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SaleController extends BaseController
{
    private final SaleService service;

    @GetMapping
    public ResponseEntity<?> getAll()
    {
        try {
            List<GetAllSalesResponse> sales = service.getAll();
            return jsonResponse(sales, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id)
    {
        try {
            GetSaleResponse sale = service.getById(id);
            return jsonResponse(sale, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Sale not found for ID: " + id));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> add(@Valid @RequestBody CreateSaleRequest request)
    {
        try {
            CreateSaleResponse sale = service.add(request);
            return jsonResponse(sale, HttpStatus.CREATED);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.BAD_REQUEST, Map.of());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UpdateSaleRequest request)
    {
        try {
            UpdateSaleResponse sale = service.update(id, request);
            return jsonResponse(sale, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Sale not found for ID: " + id));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id)
    {
        try {
            service.delete(id);
            return jsonResponse("Sale deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("id", "Unable to delete sale for ID: " + id));
        }
    }

    @GetMapping("/number/{saleNumber}")
    public ResponseEntity<?> getSalesBySaleNumber(@PathVariable String saleNumber)
    {
        try {
            List<GetAllSalesResponse> sales = service.getSalesBySaleNumber(saleNumber);
            return jsonResponse(sales, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.NOT_FOUND, Map.of("saleNumber", "Sales not found for Sale Number: " + saleNumber));
        }
    }

    @GetMapping("/grouped-by-sale-number")
    public ResponseEntity<?> getSalesGroupedBySaleNumber()
    {
        try {
            List<Object[]> groupedSales = service.getSalesGroupedBySaleNumber();
            return jsonResponse(groupedSales, HttpStatus.OK);
        } catch (Exception ex) {
            return jsonError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, Map.of());
        }
    }
}

