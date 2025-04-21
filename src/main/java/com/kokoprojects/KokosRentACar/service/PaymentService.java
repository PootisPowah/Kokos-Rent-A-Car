package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    PaymentDTO getPaymentById(long id);
    List<PaymentDTO> getAllPayments();
    PaymentDTO createPayment(PaymentDTO paymentDTO);
    PaymentDTO updatePayment(PaymentDTO paymentDTO, long id);
    void deletePaymentById(long id);

    Double calculateTotalAmount()
}
