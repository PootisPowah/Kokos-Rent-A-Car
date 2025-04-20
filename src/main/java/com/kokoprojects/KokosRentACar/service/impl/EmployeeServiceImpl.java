package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Employee;
import com.kokoprojects.KokosRentACar.entity.Office;
import com.kokoprojects.KokosRentACar.entity.Role;
import com.kokoprojects.KokosRentACar.entity.dto.EmployeeDTO;
import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.EmployeeMapper;
import com.kokoprojects.KokosRentACar.repository.EmployeeRepository;
import com.kokoprojects.KokosRentACar.repository.OfficeRepository;
import com.kokoprojects.KokosRentACar.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, OfficeRepository officeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id: " + id +" not found"));
        return employeeMapper.entityToDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.dtoToEntity(employeeDTO);
        Office office = officeRepository.findById(employeeDTO.getOfficeId()).orElseThrow(()->new RuntimeException("Office with id: " + employeeDTO.getOfficeId() + "not found")  );
        employee.setRole(Role.Employee);
        employee.setOffice(office);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.entityToDto(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee with id: " + id +" not found"));
        employeeMapper.updateEmployee(employeeDTO,employee);
        Office office = officeRepository.findById(employeeDTO.getOfficeId())
                .orElseThrow(() -> new RuntimeException("Office with ID " + employeeDTO.getOfficeId() + " not found"));
        employee.setOffice(office);
        Employee updatedEmployee = employeeRepository.save(employee);
        return employeeMapper.entityToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(long id) {
    employeeRepository.deleteById(id);
    }
}
