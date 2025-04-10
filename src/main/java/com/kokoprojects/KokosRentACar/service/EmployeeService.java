package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO getEmployeeById(long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, long id);
    void deleteEmployee(long id);
}
