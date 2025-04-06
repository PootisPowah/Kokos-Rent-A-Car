package com.kokoprojects.KokosRentACar.entity.dto.mapper;

import com.kokoprojects.KokosRentACar.entity.User;
import com.kokoprojects.KokosRentACar.entity.dto.UserBaseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBaseMapper {

    UserBaseDTO entityToDTO(User user);

    User dtoToEntity(UserBaseDTO userBaseDTO);

}
