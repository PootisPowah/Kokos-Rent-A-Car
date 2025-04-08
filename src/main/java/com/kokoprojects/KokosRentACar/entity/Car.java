package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    //vin
    @NotNull(message = "Car details (VIN) must be provided")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "vin", unique = true, nullable = true)
    private CarDetails carDetails;

    @NotNull(message = "Rental rate is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Rental rate must be greater than 0")
    @Column(name = "rental_rate", nullable = true)
    private Double rentalRate;

    @Column(name = "is_available", nullable = false)
    private Boolean  isAvailable;
}
