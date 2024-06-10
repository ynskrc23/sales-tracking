package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.sale.CreateSaleRequest;
import com.example.salestracking.dto.request.sale.UpdateSaleRequest;
import com.example.salestracking.dto.response.sale.CreateSaleResponse;
import com.example.salestracking.dto.response.sale.GetAllSalesResponse;
import com.example.salestracking.dto.response.sale.GetSaleResponse;
import com.example.salestracking.dto.response.sale.UpdateSaleResponse;
import com.example.salestracking.model.Customer;
import com.example.salestracking.model.Product;
import com.example.salestracking.model.Sale;
import com.example.salestracking.repository.CustomerRepository;
import com.example.salestracking.repository.ProductRepository;
import com.example.salestracking.repository.SaleRepository;
import com.example.salestracking.service.SaleService;
import com.sun.jdi.Type;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleManager implements SaleService {

    private final SaleRepository repository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllSalesResponse> getAll()
    {
        List<Sale> sales = repository.findAll();
        return sales.stream().map(sale -> mapper.map(sale, GetAllSalesResponse.class)).toList();
    }

    @Override
    public GetSaleResponse getById(Integer id)
    {
        Sale sale = repository.findById(id).orElseThrow(null);
        return mapper.map(sale, GetSaleResponse.class);
    }

    @Override
    public CreateSaleResponse add(CreateSaleRequest request)
    {
        Sale sale = mapper.map(request, Sale.class);
        Optional<Customer> isCustomer = customerRepository.findById((long) request.getCustomer_id());
        if(isCustomer.isPresent())
        {
            sale.setCustomer(isCustomer.get());
        }

        Optional<Product> isProduct = productRepository.findById((long) request.getProduct_id());
        if(isProduct.isPresent())
        {
            sale.setProduct(isProduct.get());
        }
        BigDecimal quantity = BigDecimal.valueOf(sale.getQuantity());
        sale.setTotalAmount(quantity.multiply(isProduct.get().getPrice()));
        sale.setId(0);
        repository.save(sale);
        return mapper.map(sale, CreateSaleResponse.class);
    }

    @Override
    public UpdateSaleResponse update(Integer id, UpdateSaleRequest request)
    {
        Optional<Sale> isSale = repository.findById(id);
        if(isSale.isPresent())
        {
            Sale sale = mapper.map(request, Sale.class);
            Optional<Customer> isCustomer = customerRepository.findById((long) request.getCustomer_id());
            if(isCustomer.isPresent())
            {
                sale.setCustomer(isCustomer.get());
            }
            Optional<Product> isProduct = productRepository.findById((long) request.getProduct_id());
            if(isProduct.isPresent())
            {
                sale.setProduct(isProduct.get());
            }
            BigDecimal quantity = BigDecimal.valueOf(sale.getQuantity());
            sale.setTotalAmount(quantity.multiply(isProduct.get().getPrice()));
            sale.setId(id);
            repository.save(sale);
            return mapper.map(sale, UpdateSaleResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Integer id)
    {
        Optional<Sale> isSale = repository.findById(id);
        if(isSale.isPresent())
        {
            repository.deleteById(id);
            return "Sale deleted successfully";
        }
        return "No such sale in the database";
    }
}
