package com.carterdboyle.store.mappers;

import com.carterdboyle.store.dtos.RegisterUserRequest;
import com.carterdboyle.store.dtos.UpdateUserRequest;
import com.carterdboyle.store.dtos.UserDto;
import com.carterdboyle.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target="createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
