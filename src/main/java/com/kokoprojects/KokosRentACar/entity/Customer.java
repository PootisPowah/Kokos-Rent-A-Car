package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers", uniqueConstraints = {@UniqueConstraint(columnNames = {"drivers_license_number","id_card_number"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User{

    @NotNull(message = "Driver's license number cannot be null")
    @Size(min = 1, max = 50, message = "Driver's license number must be between 1 and 50 characters")
    @Column(name = "drivers_license_number", nullable = false, length = 50, unique = true)
    private String driversLicenseNumber;

    @NotNull(message = "ID card number cannot be null")
    @Size(min = 1, max = 50, message = "ID card number must be between 1 and 50 characters")
    @Column(name = "id_card_number", nullable = false, length = 50, unique = true)
    private String idCardNumber;
}
