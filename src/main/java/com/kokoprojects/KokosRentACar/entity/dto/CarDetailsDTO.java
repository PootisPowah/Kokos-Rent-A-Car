package com.kokoprojects.KokosRentACar.entity.dto;

import com.kokoprojects.KokosRentACar.entity.misc.VinGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CarDetailsDTO {
    private String licencePlate;
    private String brand;
    private String model;
    private String type;
    private String fuel;
    private String gearbox;
    private Integer doors;
    private Integer seats;
    private Integer horsePower;
    private Double fuelConsumption;
    private Double reservoirCapacity;
    private Integer productionYear;
    private Double trunkSpace;
    private Integer minAgeRequirement;
}
