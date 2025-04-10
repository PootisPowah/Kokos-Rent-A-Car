package com.kokoprojects.KokosRentACar.repository;

import com.kokoprojects.KokosRentACar.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Long> {
}
