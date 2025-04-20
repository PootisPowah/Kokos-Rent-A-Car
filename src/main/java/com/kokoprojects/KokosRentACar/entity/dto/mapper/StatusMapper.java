package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.Status;
import com.kokoprojects.KokosRentACar.entity.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDTO toStatusDTO(Status status);
    Status toStatus(StatusDTO statusDTO);

   void updateStatusToDTO(StatusDTO statusDTO, @MappingTarget Status status);
}
