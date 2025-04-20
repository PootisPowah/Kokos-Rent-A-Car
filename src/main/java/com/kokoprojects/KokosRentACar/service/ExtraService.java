package com.kokoprojects.KokosRentACar.service;

import com.kokoprojects.KokosRentACar.entity.dto.ExtraDTO;

import java.util.List;

public interface ExtraService {

    ExtraDTO getExtraById(long id);
    List<ExtraDTO> getAllExtras();
    ExtraDTO createExtra(ExtraDTO extrasDTO);
    ExtraDTO updateExtra(ExtraDTO extrasDTO, long id);
    void deleteExtraById(long id);
}
