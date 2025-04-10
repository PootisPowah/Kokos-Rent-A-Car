package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Office;
import com.kokoprojects.KokosRentACar.entity.dto.OfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface OfficeMapper {
    OfficeDTO entityToOfficeDto(Office office);

    Office officeDtoToEntity(OfficeDTO officeDTO);

    void updateOfficeDTO(OfficeDTO officeDTO, @MappingTarget Office office);
}
