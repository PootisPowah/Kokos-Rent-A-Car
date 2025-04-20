package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Employee;
import com.kokoprojects.KokosRentACar.entity.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = OfficeMapper.class)
public interface EmployeeMapper {

    @Mapping(source = "office.id", target = "officeId")
    EmployeeDTO entityToDto(Employee employee);

    @Mapping(source = "officeId", target = "office.id")
    Employee dtoToEntity(EmployeeDTO employeeDTO);

    @Mapping(target = "office", ignore = true)
    void updateEmployee(EmployeeDTO employeeDTO, @MappingTarget Employee employee);
}
