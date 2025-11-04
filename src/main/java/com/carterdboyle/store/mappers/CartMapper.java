package com.carterdboyle.store.mappers;

import com.carterdboyle.store.dtos.CartDto;
import com.carterdboyle.store.entities.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartDto toDto(Cart cart);
}
