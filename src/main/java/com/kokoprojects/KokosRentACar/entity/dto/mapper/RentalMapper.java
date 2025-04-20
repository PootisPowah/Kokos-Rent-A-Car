package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Rental;
import com.kokoprojects.KokosRentACar.entity.dto.RentalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "car.id", target = "carId")
    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "pickupOffice.id", target = "pickupOfficeId")
    @Mapping(source = "returnOffice.id", target = "returnOfficeId")
    @Mapping(target = "statusId", ignore = true)
    RentalDTO entityToRentalDTO(Rental rental);

    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "carId", target = "car.id")
    @Mapping(source = "employeeId", target = "employee.id")
    @Mapping(source = "pickupOfficeId", target = "pickupOffice.id")
    @Mapping(source = "returnOfficeId", target = "returnOffice.id")
    @Mapping(target = "status", ignore = true)
    Rental rentalDTOToEntity(RentalDTO rentalDTO);

    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "car", ignore = true)
    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "pickupOffice", ignore = true)
    @Mapping(target = "returnOffice", ignore = true)
    void updateRentalDTO(RentalDTO rentalDTO, @MappingTarget Rental rental);
}
