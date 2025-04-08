package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.CarDetails;
import com.kokoprojects.KokosRentACar.entity.dto.CarDetailsAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarDetailsMapper {

    CarDetailsDTO entityToDto(CarDetails carDetails);

    CarDetails dtoToEntity(CarDetailsDTO carDetailsDTO);

    CarDetailsAdminDTO entityToCarDetailsAdminDTO(CarDetails carDetails);

    CarDetails adminDTOToEntity(CarDetailsAdminDTO carDetailsAdminDTO);
}
