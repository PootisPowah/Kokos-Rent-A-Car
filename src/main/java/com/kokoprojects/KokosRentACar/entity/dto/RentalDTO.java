package com.kokoprojects.KokosRentACar.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDTO {

    private Long customerId;

    private Long carId;

    private Long employeeId;

    private Long statusId;

    @NotBlank
    private LocalTime pickupTime;
    @NotBlank
    private LocalTime returnTime;
    @NotBlank
    private LocalDate pickupDate;
    @NotBlank
    private LocalDate returnDate;
    @NotBlank
    private Long pickupOfficeId;
    @NotBlank
    private Long returnOfficeId;



}
