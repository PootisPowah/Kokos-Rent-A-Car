package com.kokoprojects.KokosRentACar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "employee_id")
public class Employee extends User{
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}
