package com.kokoprojects.KokosRentACar.repository;

import com.kokoprojects.KokosRentACar.entity.Rental;
import com.kokoprojects.KokosRentACar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
