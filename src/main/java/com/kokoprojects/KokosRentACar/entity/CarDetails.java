package com.kokoprojects.KokosRentACar.entity;


import com.kokoprojects.KokosRentACar.entity.misc.VinGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDetails {

    @Id
    //generated value for vin
    @NotNull
    @Size(min = 17, max = 17, message = "VIN must be 17 characters long")
    @Column(name = "vin", unique = true)
    private String vin = VinGenerator.generateVin();

    @NotNull
    @Size(min = 1, max = 50, message = "License plate should not be empty and should be at most 50 characters")
    @Column(name = "license_plate", unique = true)
    private String licencePlate;

    @NotNull
    @Size(min = 1, max = 50, message = "Brand name should not be empty and should be at most 50 characters")
    @Column(name = "brand")
    private String brand;

    @NotNull
    @Size(min = 1, max = 50, message = "Model name should not be empty and should be at most 50 characters")
    @Column(name = "model")
    private String model;

    @NotNull
    @Size(min = 1, max = 50, message = "Type should not be empty and should be at most 50 characters")
    @Column(name = "type")
    private String type;

    @NotNull
    @Size(min = 1, max = 50, message = "Fuel type should not be empty and should be at most 50 characters")
    @Column(name = "fuel")
    private String fuel;

    @NotNull
    @Size(min = 1, max = 50, message = "Gearbox type should not be empty and should be at most 50 characters")
    @Column(name = "gearbox")
    private String gearbox;

    @NotNull
    @Min(value = 2, message = "Car must have at least 2 doors")
    @Column(name = "doors")
    private Integer doors;

    @NotNull
    @Min(value = 1, message = "Car must have at least 1 seat")
    @Column(name = "seats")
    private Integer seats;

    @NotNull
    @Min(value = 1, message = "Horsepower must be at least 1")
    @Column(name = "horse_power")
    private Integer horsePower;

    @NotNull
    @DecimalMin(value = "0.1", message = "Fuel consumption must be a positive number")
    @Column(name = "fuel_consumption")
    private Double fuelConsumption;

    @DecimalMin(value = "0", message = "Reservoir capacity must be at least 0")
    @Column(name = "reservoir_capacity")
    private Double reservoirCapacity;

    @NotNull
    @Min(value = 1886, message = "Car production year must be after 1886")
    @Column(name = "production_year")
    private Integer productionYear;

    @DecimalMin(value = "0", message = "Trunk space must be at least 0")
    @Column(name = "trunk_space")
    private Double trunkSpace;

    @NotNull
    @Min(value = 18, message = "The minimum age requirement for driving should be at least 18")
    @Column(name = "min_age_requirement")
    private Integer minAgeRequirement;
}
