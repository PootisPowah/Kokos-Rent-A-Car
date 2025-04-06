package com.kokoprojects.KokosRentACar.entity.dto;

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


    private LocalTime pickupTime;

    private LocalTime returnTime;

    private LocalDate pickupDate;

    private LocalDate returnDate;

    private Long pickupOfficeId;

    private Long returnOfficeId;



}
