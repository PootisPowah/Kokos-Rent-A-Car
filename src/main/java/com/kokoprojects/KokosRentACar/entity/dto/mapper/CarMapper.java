package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Car;
import com.kokoprojects.KokosRentACar.entity.dto.CarAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CarDetailsDTO.class})
public interface CarMapper {

    CarDTO toCarDTO(Car car);
    Car toCar(CarDTO carDTO);

    // For admin use
    CarAdminDTO toCarAdminDTO(Car car);
    Car toCar(CarAdminDTO carAdminDTO);

}
