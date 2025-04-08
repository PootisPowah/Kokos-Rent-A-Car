package com.kokoprojects.KokosRentACar.entity.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO{

    private CarDetailsDTO carDetails;

    private Double rentalRate;

    private Boolean  isAvailable;


}
