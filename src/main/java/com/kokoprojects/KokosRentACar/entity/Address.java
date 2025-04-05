package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @NotNull(message = "Country code cannot be null")
    @Pattern(regexp = "^[A-Z]{2}$", message = "Country code must be exactly 2 uppercase letters")
    @Column(name = "country_code", nullable = false, length = 2)
    private String countryCode = "BG";

    @NotBlank(message = "City name cannot be blank")
    @Size(min = 2, max = 50, message = "City name must be between 2 and 50 characters")
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @NotBlank(message = "Street name cannot be blank")
    @Size(min = 2, max = 50, message = "Street name must be between 2 and 50 characters")
    @Column(name = "street_name", nullable = false, length = 50)
    private String streetName;

    @NotBlank(message = "Street number cannot be blank")
    @Size(min = 1, max = 10, message = "Street number must be between 1 and 10 characters")
    @Column(name = "street_number", nullable = false, length = 10)
    private String streetNumber;
}
