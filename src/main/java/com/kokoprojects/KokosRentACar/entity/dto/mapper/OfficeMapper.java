package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Office;
import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    OfficeDTO entityToOfficeDto(Office office);

    Office officeDtoToEntity(OfficeDTO officeDTO);
}
