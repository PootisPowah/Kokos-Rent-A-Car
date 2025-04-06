package com.kokoprojects.KokosRentACar.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO{
    private Long id;

    private Double rentalRate;

    private Boolean  isAvailable;

    private CarDetailsDTO carDetails;

}
