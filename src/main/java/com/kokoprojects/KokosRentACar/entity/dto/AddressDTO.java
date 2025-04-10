package com.kokoprojects.KokosRentACar.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    //private String countryCode = "BG";
    private String city;
    private String streetName;
    private String streetNumber;
}
