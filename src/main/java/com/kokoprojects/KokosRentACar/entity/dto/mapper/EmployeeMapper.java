package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Employee;
import com.kokoprojects.KokosRentACar.entity.dto.EmployeeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO entityToDto(Employee employee);

    Employee dtoToEntity(EmployeeDTO employeeDTO);
}
