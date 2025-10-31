package com.carterdboyle.store.mappers;

import com.carterdboyle.store.dtos.UserDto;
import com.carterdboyle.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target="createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
