package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @NotNull(message = "Rental must be associated with the payment")
    @OneToOne(optional = false)
    @JoinColumn(name = "rental_id", nullable = false, unique = true)
    private Rental rental;

    @NotNull(message = "Total amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Total amount must be greater than 0")
    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @NotNull(message = "Payment date is required")
    @PastOrPresent(message = "Payment date cannot be in the future")
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @NotBlank(message = "Payment method is required")
    @Size(max = 50, message = "Payment method must not exceed 50 characters")
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @DecimalMin(value = "0.0", inclusive = true, message = "Insurance price cannot be negative")
    @Column(name = "insurance_price")
    private Double insurancePrice;

    @DecimalMin(value = "0.0", inclusive = true, message = "Deposit cannot be negative")
    @Column(name = "deposit")
    private Double deposit;

    @ManyToMany
    @JoinTable(
            name = "payment_extras",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    private List<Extra> paymentExtras;
}
