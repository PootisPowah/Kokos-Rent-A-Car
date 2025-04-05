package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="statuses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long id;

    @NotNull(message = "Status name is required")
    @Size(min = 1, max = 50, message = "Status name must be between 1 and 50 characters")
    @Column(name = "status_name", nullable = false, unique = true)
    private String name;

    @Size(max = 200, message = "Status description cannot be more than 200 characters")
    @Column(name = "status_description")
    private String description;
}

