package com.kokoprojects.KokosRentACar.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailsAdminDTO extends CarDetailsDTO {
    private String vin;

}
