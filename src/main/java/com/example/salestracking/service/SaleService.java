package com.example.salestracking.service;

import com.example.salestracking.dto.request.sale.CreateSaleRequest;
import com.example.salestracking.dto.request.sale.UpdateSaleRequest;
import com.example.salestracking.dto.response.sale.CreateSaleResponse;
import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import com.example.salestracking.dto.response.sale.GetSaleResponse;
import com.example.salestracking.dto.response.sale.UpdateSaleResponse;
import com.example.salestracking.model.Sale;

import java.util.List;
import java.util.Map;

public interface SaleService {
    List<GetAllSalesResponse> getAll();
    GetSaleResponse getById(Integer id);
    CreateSaleResponse add(CreateSaleRequest request);
    UpdateSaleResponse update(Integer id, UpdateSaleRequest request);
    String delete(Integer id);
    List<GetAllSalesResponse> getSalesBySaleNumber(String saleNumber);
    List<Object[]> getSalesGroupedBySaleNumber();
}
