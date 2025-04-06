package com.kokoprojects.KokosRentACar.entity.dto;

import com.kokoprojects.KokosRentACar.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBaseDTO {
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate birthDate;
    private Role role;
}
