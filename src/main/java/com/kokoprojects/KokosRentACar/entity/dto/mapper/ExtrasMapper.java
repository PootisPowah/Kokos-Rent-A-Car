package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Extra;
import com.kokoprojects.KokosRentACar.entity.dto.ExtraDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ExtrasMapper {

    ExtraDTO entityToDTO(Extra extra);

    Extra DTOtoEntity(ExtraDTO extraDTO);

    void updateExtraDTO(ExtraDTO extraDTO, @MappingTarget Extra extra);
}
