package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;

import java.util.List;

public interface OfficeService {
    OfficeDTO getOfficeById(long id);
    List<OfficeDTO> getAllOffices();
    OfficeDTO createOffice(OfficeDTO officeDTO);
    OfficeDTO updateOffice(OfficeDTO officeDTO, long id);
    void deleteOffice(long id);

}
