package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Customer;
import com.kokoprojects.KokosRentACar.entity.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO entityToDto(Customer customer);

    Customer dtoToEntity(CustomerDTO customerDTO);

    @Mapping(target = "driversLicenseNumber", ignore = true)
    @Mapping(target = "idCardNumber", ignore = true)
    void updateCustomer(CustomerDTO customerDTO, @MappingTarget Customer customer);
}
