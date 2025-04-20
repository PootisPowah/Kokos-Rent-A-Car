package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.RentalDTO;
import com.kokoprojects.KokosRentACar.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDTO> getRentalById(@PathVariable long id) {
        RentalDTO rental = rentalService.getRentalById(id);
        return ResponseEntity.ok(rental);
    }

    @GetMapping
    public ResponseEntity<List<RentalDTO>> getAllRentals() {
        List<RentalDTO> rentals = rentalService.getRentals();
        return ResponseEntity.ok(rentals);
    }

    @PostMapping
    public ResponseEntity<RentalDTO> createRental(@RequestBody RentalDTO rentalDTO) {
        RentalDTO rental = rentalService.createRental(rentalDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(rental);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalDTO> updateRental (@PathVariable long id, @RequestBody RentalDTO rentalDTO){
        RentalDTO rental = rentalService.updateRental(rentalDTO, id);
        return ResponseEntity.ok(rental);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable long id) {
        rentalService.deleteRentalById(id);
        return ResponseEntity.noContent().build();
    }
}
