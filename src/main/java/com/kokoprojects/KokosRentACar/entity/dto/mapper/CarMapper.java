package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Car;
import com.kokoprojects.KokosRentACar.entity.dto.CarAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDetailsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CarDetailsMapper.class})
public interface CarMapper {
    CarDTO toCarDTO(Car car);

    Car toCar(CarDTO carDTO);

    @Mapping(target = "id", ignore = true)
    void updateCar(CarDTO carDTO, @MappingTarget Car car);

    // For admin use
    CarAdminDTO toCarAdminDTO(Car car);
    Car toCar(CarAdminDTO carAdminDTO);

}
