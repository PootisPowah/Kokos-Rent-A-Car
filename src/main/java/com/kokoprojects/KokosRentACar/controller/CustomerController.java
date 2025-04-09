package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.CustomerDTO;
import com.kokoprojects.KokosRentACar.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerDTOList);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
       CustomerDTO createdCustomer = customerService.addCustomer(customerDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable long id){
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerDTO,id);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }
}
