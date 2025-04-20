package com.kokoprojects.KokosRentACar.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtraDTO {

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private Double price;
}
