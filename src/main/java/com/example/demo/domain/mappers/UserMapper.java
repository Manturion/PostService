package com.example.demo.domain.mappers;

import com.example.demo.domain.entities.UserEntity;
import com.example.demo.infrastructure.User.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity mapToEntity(UserDto userDto);
    UserDto mapToDto(UserEntity userEntity);
}
