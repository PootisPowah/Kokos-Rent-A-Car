package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Customer;
import com.kokoprojects.KokosRentACar.entity.Role;
import com.kokoprojects.KokosRentACar.entity.dto.CustomerDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.CustomerMapper;
import com.kokoprojects.KokosRentACar.repository.CustomerRepository;
import com.kokoprojects.KokosRentACar.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO getCustomerById(long id) {

        Customer customer = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer with " + id + "not found"));
        return customerMapper.entityToDto(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.dtoToEntity(customerDTO);
        customer.setRole(Role.Customer);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.entityToDto(savedCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO, long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->new RuntimeException("Customer with " + customerId + "not found"));
        customerMapper.updateCustomer(customerDTO,customer);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.entityToDto(savedCustomer);
    }

    @Override
    public void deleteCustomer(long id) {

        customerRepository.deleteById(id);
    }
}
