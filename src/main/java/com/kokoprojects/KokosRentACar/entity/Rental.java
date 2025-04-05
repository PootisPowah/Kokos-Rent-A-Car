package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "rentals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @NotNull(message = "Pickup time is required")
    @Column(name = "pickup_time")
    private LocalTime pickupTime;

    @NotNull(message = "Return time is required")
    @Column(name = "return_time")
    private LocalTime returnTime;

    @ManyToOne
    @JoinColumn(name = "pickup_office_id", nullable = false)
    private Office pickupOffice;

    @ManyToOne
    @JoinColumn(name = "return_office_id", nullable = false)
    private Office returnOffice;

    @NotNull(message = "Pickup date is required")
    @Column(name = "pickup_date")
    private LocalDate pickupDate;

    @NotNull(message = "Return date is required")
    @Column(name = "return_date")
    private LocalDate returnDate;
}

