package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "extras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Extra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extra_id")
    private Long id;

    @NotBlank(message = "Extra name is required")
    @Size(max = 100, message = "Name can be max 100 characters")
    @Column(name = "extra_name", nullable = false, unique = true)
    private String name;

    @Size(max = 255, message = "Description can be max 255 characters")
    @Column(name = "extra_description")
    private String description;

    @ManyToMany(mappedBy = "paymentExtras")
    private Set<Payment> payments;
}
