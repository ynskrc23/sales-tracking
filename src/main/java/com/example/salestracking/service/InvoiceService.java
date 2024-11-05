package com.example.salestracking.service;

import com.example.salestracking.dto.request.invoice.CreateInvoiceRequest;
import com.example.salestracking.dto.request.invoice.UpdateInvoiceRequest;
import com.example.salestracking.dto.response.invoice.CreateInvoiceResponse;
import com.example.salestracking.dto.response.invoice.GetAllInvoicesResponse;
import com.example.salestracking.dto.response.invoice.GetInvoiceResponse;
import com.example.salestracking.dto.response.invoice.UpdateInvoiceResponse;

import java.util.List;

public interface InvoiceService
{
    List<GetAllInvoicesResponse> getAll();
    GetInvoiceResponse getById(Integer id);
    CreateInvoiceResponse add(CreateInvoiceRequest request);
    UpdateInvoiceResponse update(Integer id, UpdateInvoiceRequest request);
    String delete(Integer id);
}
