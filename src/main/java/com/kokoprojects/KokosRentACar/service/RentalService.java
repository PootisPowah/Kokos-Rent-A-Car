package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.RentalDTO;

import java.util.List;

public interface RentalService {

    RentalDTO getRentalById(long id);
    List<RentalDTO> getRentals();
    RentalDTO createRental(RentalDTO rentalDTO);
    RentalDTO updateRental(RentalDTO rentalDTO, long id);
    void deleteRentalById(long id);
}
