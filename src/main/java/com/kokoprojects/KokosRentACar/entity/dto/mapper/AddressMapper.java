package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Address;
import com.kokoprojects.KokosRentACar.entity.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO entityToAddressDTO(Address address);

    Address addressDTOToEntity(AddressDTO addressDTO);
}
