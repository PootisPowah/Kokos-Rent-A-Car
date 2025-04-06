package com.kokoprojects.KokosRentACar.service;


import com.kokoprojects.KokosRentACar.entity.dto.CarAdminDTO;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO getCarById(Long id);
    List<CarDTO> getAllCars();
    void addCar(CarAdminDTO carAdminDTO);
    void updateCar(CarAdminDTO carAdminDTO);
    void deleteCarById(Long id);
}
