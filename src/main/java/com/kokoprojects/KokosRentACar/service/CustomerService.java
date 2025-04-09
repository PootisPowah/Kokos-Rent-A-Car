package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomerById(long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO addCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO, long customerId);
    void deleteCustomer(long id);
}
