package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.invoice.CreateInvoiceRequest;
import com.example.salestracking.dto.request.invoice.UpdateInvoiceRequest;
import com.example.salestracking.dto.response.invoice.CreateInvoiceResponse;
import com.example.salestracking.dto.response.invoice.GetAllInvoicesResponse;
import com.example.salestracking.dto.response.invoice.GetInvoiceResponse;
import com.example.salestracking.dto.response.invoice.UpdateInvoiceResponse;
import com.example.salestracking.model.Invoice;
import com.example.salestracking.model.Sale;
import com.example.salestracking.repository.InvoiceRepository;
import com.example.salestracking.repository.SaleRepository;
import com.example.salestracking.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {

    private final InvoiceRepository repository;
    private final SaleRepository saleRepository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllInvoicesResponse> getAll()
    {
        List<Invoice> invoices = repository.findAll();
        return invoices.stream().map(invoice -> mapper.map(invoice, GetAllInvoicesResponse.class)).toList();
    }

    @Override
    public GetInvoiceResponse getById(Integer id)
    {
        Invoice invoice = repository.findById(Long.valueOf(id)).orElseThrow(null);
        return mapper.map(invoice, GetInvoiceResponse.class);
    }

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest request)
    {
        Invoice invoice = mapper.map(request, Invoice.class);
        Optional<Sale> isSale = saleRepository.findById((long) request.getSale_id());
        if(isSale.isPresent())
        {
            invoice.setSale(isSale.get());
        }
        invoice.setInvoiceId(0L);
        repository.save(invoice);
        return mapper.map(invoice, CreateInvoiceResponse.class);
    }

    @Override
    public UpdateInvoiceResponse update(Integer id, UpdateInvoiceRequest request)
    {
        Invoice invoice = mapper.map(request, Invoice.class);
        Optional<Sale> isSale = saleRepository.findById((long) request.getSale_id());
        if(isSale.isPresent())
        {
            invoice.setSale(isSale.get());
        }
        invoice.setInvoiceId(Long.valueOf(id));
        repository.save(invoice);
        return mapper.map(invoice, UpdateInvoiceResponse.class);
    }

    @Override
    public String delete(Integer id)
    {
        Optional<Invoice> isInvoice = repository.findById(Long.valueOf(id));
        if(isInvoice.isPresent())
        {
            repository.deleteById(Long.valueOf(id));
            return "Invoice deleted successfully";
        }
        return "No such invoice in the database";
    }
}
