package com.kokoprojects.KokosRentACar.service;


import com.kokoprojects.KokosRentACar.entity.Car;
import com.kokoprojects.KokosRentACar.entity.dto.CarAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    CarDTO addCar(CarDTO carDTO);
    CarDTO updateCar(CarDTO carDTO, long carId);
    void deleteCarById(Long id);
}
