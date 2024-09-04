package com.example.salestracking.service.impl;

import com.example.salestracking.dto.request.customer.CreateCustomerRequest;
import com.example.salestracking.dto.request.customer.UpdateCustomerRequest;
import com.example.salestracking.dto.response.customer.CreateCustomerResponse;
import com.example.salestracking.dto.response.customer.GetAllCustomersResponse;
import com.example.salestracking.dto.response.customer.GetCustomerResponse;
import com.example.salestracking.dto.response.customer.UpdateCustomerResponse;
import com.example.salestracking.model.Customer;
import com.example.salestracking.repository.CustomerRepository;
import com.example.salestracking.service.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService
{
    private final CustomerRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllCustomersResponse> getAll()
    {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(customer -> mapper.map(customer, GetAllCustomersResponse.class)).toList();
    }

    @Override
    public GetCustomerResponse getById(Long id)
    {
        Customer customer = repository.findById(id).orElseThrow();
        return mapper.map(customer, GetCustomerResponse.class);
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request)
    {
        Customer customer = mapper.map(request, Customer.class);
        customer.setCustomerId(0L);
        repository.save(customer);
        return mapper.map(customer, CreateCustomerResponse.class);
    }

    @Override
    public UpdateCustomerResponse update(Long id, UpdateCustomerRequest request)
    {
        Optional<Customer> isCustomer = repository.findById(id);
        if(isCustomer.isPresent())
        {
            Customer customer = mapper.map(request, Customer.class);
            customer.setCustomerId((long) Math.toIntExact(id));
            repository.save(customer);
            return mapper.map(customer, UpdateCustomerResponse.class);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Optional<Customer> isCustomer = repository.findById(id);
        if(isCustomer.isPresent())
        {
            repository.deleteById(id);
            return "Customer deleted successfully";
        }
        return "No such customer in the database";
    }
}
