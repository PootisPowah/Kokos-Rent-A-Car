package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.StatusDTO;

import java.util.List;

public interface StatusService {

    StatusDTO getStatusById(long id);
    List<StatusDTO> getAllStatuses();
    StatusDTO createStatus(StatusDTO statusDTO);
    StatusDTO updateStatus(StatusDTO statusDTO,long id);
    void deleteStatusById(long id);

}
