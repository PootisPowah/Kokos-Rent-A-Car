package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Rental;
import com.kokoprojects.KokosRentACar.entity.dto.RentalDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.RentalMapper;
import com.kokoprojects.KokosRentACar.repository.RentalRepository;
import com.kokoprojects.KokosRentACar.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public RentalServiceImpl(RentalRepository rentalRepository, RentalMapper rentalMapper) {
        this.rentalRepository = rentalRepository;

        this.rentalMapper = rentalMapper;
    }

    @Override
    public RentalDTO getRentalById(long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental with id:" + id + " not found"));
        return rentalMapper.entityToRentalDTO(rental);
    }

    @Override
    public List<RentalDTO> getRentals() {
        List<Rental> rentals = rentalRepository.findAll();
        return rentals.stream().map(rentalMapper::entityToRentalDTO).collect(Collectors.toList());
    }

    @Override
    public RentalDTO createRental(RentalDTO rentalDTO) {
        rentalDTO.setStatusId(2L);
        Rental rental = rentalMapper.rentalDTOToEntity(rentalDTO);
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.entityToRentalDTO(savedRental);
    }

    @Override
    public RentalDTO updateRental(RentalDTO rentalDTO, long id) {
        Rental rental = rentalRepository.findById(id).orElseThrow(() -> new RuntimeException("Rental with id:" + id + " not found"));
        rentalMapper.updateRentalDTO(rentalDTO,rental);
        Rental savedRental = rentalRepository.save(rental);
        return rentalMapper.entityToRentalDTO(savedRental);
    }

    @Override
    public void deleteRentalById(long id) {
        rentalRepository.deleteById(id);
    }
}
