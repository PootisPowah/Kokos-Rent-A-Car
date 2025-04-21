package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Payment;
import com.kokoprojects.KokosRentACar.entity.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO entityToPaymentDTO(Payment payment);

    Payment dtoToEntity(PaymentDTO paymentDTO);

    void updatePaymentDTO(PaymentDTO paymentDTO, @MappingTarget Payment payment);

}
