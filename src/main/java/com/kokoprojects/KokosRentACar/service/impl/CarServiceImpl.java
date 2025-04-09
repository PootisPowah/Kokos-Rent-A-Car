package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Car;
import com.kokoprojects.KokosRentACar.entity.dto.CarDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.CarMapper;
import com.kokoprojects.KokosRentACar.repository.CarRepository;
import com.kokoprojects.KokosRentACar.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;
    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDTO getCarById(long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car with id " + id + " not found"));  ;
        return carMapper.toCarDTO(car);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> carList = carRepository.findAll();
        return carList.stream().map(carMapper::toCarDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO addCar(CarDTO carDTO) {

        Car car = carMapper.toCar(carDTO);
        Car savedCar = carRepository.save(car);
        return carMapper.toCarDTO(savedCar);

    }

    @Override
    public CarDTO updateCar(CarDTO carDTO, long carId) {

        Car car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car with id " + carId + " not found"));  ;
        carMapper.updateCar(carDTO, car);

        //update carDetails also
        if(car.getCarDetails() != null &&  carDTO.getCarDetails() == null){
            carMapper.updateCarDetails(carDTO.getCarDetails(),car.getCarDetails());
        }
        Car savedCar = carRepository.save(car);
        return carMapper.toCarDTO(savedCar);
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);

    }
}
