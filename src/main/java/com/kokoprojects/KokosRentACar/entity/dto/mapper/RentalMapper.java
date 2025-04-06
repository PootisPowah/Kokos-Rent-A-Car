package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Rental;
import com.kokoprojects.KokosRentACar.entity.dto.RentalDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalMapper {


    RentalDTO entityToRentalDTO(Rental rental);

    Rental rentalDTOToEntity(RentalDTO rentalDTO);
}
