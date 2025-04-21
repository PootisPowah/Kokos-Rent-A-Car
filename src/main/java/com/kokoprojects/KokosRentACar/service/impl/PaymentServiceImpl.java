package com.kokoprojects.KokosRentACar.service.impl;

import com.kokoprojects.KokosRentACar.entity.Payment;
import com.kokoprojects.KokosRentACar.entity.dto.PaymentDTO;
import com.kokoprojects.KokosRentACar.entity.dto.mapper.PaymentMapper;
import com.kokoprojects.KokosRentACar.repository.PaymentRepository;
import com.kokoprojects.KokosRentACar.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }
    @Override
    public PaymentDTO getPaymentById(long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("Payment with id: " + id + "not found"));
        return paymentMapper.entityToPaymentDTO(payment);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(paymentMapper::entityToPaymentDTO).collect(Collectors.toList());
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.dtoToEntity(paymentDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.entityToPaymentDTO(savedPayment);
    }

    @Override
    public PaymentDTO updatePayment(PaymentDTO paymentDTO, long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()-> new RuntimeException("Payment with id: " + id + "not found"));
        paymentMapper.updatePaymentDTO(paymentDTO,payment);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.entityToPaymentDTO(savedPayment);
    }

    @Override
    public void deletePaymentById(long id) {
        paymentRepository.deleteById(id);
    }


}
