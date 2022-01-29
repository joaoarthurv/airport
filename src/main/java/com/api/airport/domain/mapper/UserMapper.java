package com.api.airport.domain.mapper;

import com.api.airport.domain.dto.UserDTO;
import com.api.airport.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(target = "userId", ignore = true),
            @Mapping(target = "userEmail"),
            @Mapping(target = "name"),
            @Mapping(target = "password"),
            @Mapping(target = "role")
    })
    UserEntity toUserEntityWithoutId(UserDTO userDTO);

    @Mappings({
            @Mapping(target = "userId"),
            @Mapping(target = "userEmail"),
            @Mapping(target = "name"),
            @Mapping(target = "password"),
            @Mapping(target = "role")
    })
    UserDTO toUserDTO(UserEntity userEntity);
}
