package com.kokoprojects.KokosRentACar.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private Long rentalId;

    private Double totalAmount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private Double insurancePrice;

    private Double deposit;

    private List<Long> extrasIds;
}
