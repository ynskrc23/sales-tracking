package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.salesperson.CreateSalespersonRequest;
import com.example.salestracking.dto.request.salesperson.UpdateSalespersonRequest;
import com.example.salestracking.dto.response.salesperson.CreateSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.GetAllSalespersonsResponse;
import com.example.salestracking.dto.response.salesperson.GetSalespersonResponse;
import com.example.salestracking.dto.response.salesperson.UpdateSalespersonResponse;
import com.example.salestracking.model.Salesperson;
import com.example.salestracking.repository.SalespersonRepository;
import com.example.salestracking.service.SalespersonService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalespersonManager implements SalespersonService
{
    private final SalespersonRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllSalespersonsResponse> getAll()
    {
        List<Salesperson> Salespersons = repository.findAll();
        return Salespersons.stream().map(Salesperson -> mapper.map(Salesperson, GetAllSalespersonsResponse.class)).toList();
    }

    @Override
    public GetSalespersonResponse getById(Long id)
    {
        Salesperson salesperson = repository.findById(id).orElseThrow();
        return mapper.map(salesperson, GetSalespersonResponse.class);
    }

    @Override
    public CreateSalespersonResponse add(CreateSalespersonRequest request)
    {
        Salesperson salesperson = mapper.map(request, Salesperson.class);
        salesperson.setSalespersonId(0L);
        repository.save(salesperson);
        return mapper.map(salesperson, CreateSalespersonResponse.class);
    }

    @Override
    public UpdateSalespersonResponse update(Long id, UpdateSalespersonRequest request)
    {
        Optional<Salesperson> isSalesperson = repository.findById(id);
        if(isSalesperson.isPresent())
        {
            Salesperson salesperson = mapper.map(request, Salesperson.class);
            salesperson.setSalespersonId((long) Math.toIntExact(id));
            repository.save(salesperson);
            return mapper.map(salesperson, UpdateSalespersonResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Long id)
    {
        Optional<Salesperson> isSalesperson = repository.findById(id);
        if(isSalesperson.isPresent())
        {
            repository.deleteById(id);
            return "Salesperson deleted successfully";
        }
        return "No such salesperson in the database";
    }
}
