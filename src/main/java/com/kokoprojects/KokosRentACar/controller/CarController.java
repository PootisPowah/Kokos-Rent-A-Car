package com.kokoprojects.KokosRentACar.controller;

import com.kokoprojects.KokosRentACar.entity.dto.CarAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;
import com.kokoprojects.KokosRentACar.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable long id) {
        CarDTO carDTO = carService.getCarById(id);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<CarDTO> carDTOList = carService.getAllCars();
        return ResponseEntity.ok(carDTOList);
    }

    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody CarAdminDTO carAdminDTO) {
        carService.addCar(carAdminDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable long id){
        carService.deleteCarById(id);
        return ResponseEntity.ok().build();
    }
}
