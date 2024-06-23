package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.salesrepresentative.CreateSalesRepresentativeRequest;
import com.example.salestracking.dto.request.salesrepresentative.UpdateSalesRepresentativeRequest;
import com.example.salestracking.dto.response.salesrepresentative.CreateSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetAllSalesRepresentativesResponse;
import com.example.salestracking.dto.response.salesrepresentative.GetSalesRepresentativeResponse;
import com.example.salestracking.dto.response.salesrepresentative.UpdateSalesRepresentativeResponse;
import com.example.salestracking.model.SalesRepresentative;
import com.example.salestracking.repository.SalesRepresentativeRepository;
import com.example.salestracking.service.SalesRepresentativeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesRepresentativeManager implements SalesRepresentativeService {

    private final SalesRepresentativeRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllSalesRepresentativesResponse> getAll()
    {
        List<SalesRepresentative> salesrepresentatives = repository.findAll();
        return salesrepresentatives.stream().map(salesrepresentative -> mapper.map(salesrepresentative, GetAllSalesRepresentativesResponse.class)).toList();
    }

    @Override
    public GetSalesRepresentativeResponse getById(Integer id)
    {
        SalesRepresentative salesrepresentative = repository.findById(id).orElseThrow(null);
        return mapper.map(salesrepresentative, GetSalesRepresentativeResponse.class);
    }

    @Override
    public CreateSalesRepresentativeResponse add(CreateSalesRepresentativeRequest request)
    {
        SalesRepresentative salesrepresentative = mapper.map(request, SalesRepresentative.class);
        salesrepresentative.setId(0);
        repository.save(salesrepresentative);
        return mapper.map(salesrepresentative, CreateSalesRepresentativeResponse.class);
    }

    @Override
    public UpdateSalesRepresentativeResponse update(Integer id, UpdateSalesRepresentativeRequest request)
    {
        Optional<SalesRepresentative> isSalesRepresentative = repository.findById(id);
        if(isSalesRepresentative.isPresent())
        {
            SalesRepresentative salesrepresentative = mapper.map(request, SalesRepresentative.class);
            salesrepresentative.setId(Math.toIntExact(id));
            repository.save(salesrepresentative);
            return mapper.map(salesrepresentative, UpdateSalesRepresentativeResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Integer id)
    {
        Optional<SalesRepresentative> isSalesRepresentative = repository.findById(id);
        if(isSalesRepresentative.isPresent())
        {
            repository.deleteById(id);
            return "Sales representative deleted successfully";
        }
        return "No such sales representative in the database";
    }
}
