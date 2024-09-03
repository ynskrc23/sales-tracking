package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.sale.CreateSaleRequest;
import com.example.salestracking.dto.request.sale.UpdateSaleRequest;
import com.example.salestracking.dto.response.sale.CreateSaleResponse;
import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import com.example.salestracking.dto.response.sale.GetSaleResponse;
import com.example.salestracking.dto.response.sale.UpdateSaleResponse;
import com.example.salestracking.repository.SaleRepository;
import com.example.salestracking.rules.sale.StockRules;
import com.example.salestracking.service.SaleService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {

    private final SaleRepository repository;

    private final ModelMapper mapper;
    private final StockRules stockRules;

    @Override
    public List<GetAllSalesResponse> getAll()
    {
       return null;
    }

    @Override
    public GetSaleResponse getById(Integer id)
    {
        return null;
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request)
    {
        return null;
    }

    @Override
    public UpdateSaleResponse update(Integer id, UpdateSaleRequest request)
    {
        return null;
    }

    @Override
    public String delete(Integer id)
    {
        return null;
    }

    public List<GetAllSalesResponse> getSalesBySaleNumber(String saleNumber)
    {
        return null;
    }
    public List<Object[]> getSalesGroupedBySaleNumber()
    {
        return null;
    }
}
