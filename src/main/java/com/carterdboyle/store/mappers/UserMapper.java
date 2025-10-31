package com.carterdboyle.store.mappers;

import com.carterdboyle.store.dtos.UserDto;
import com.carterdboyle.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
