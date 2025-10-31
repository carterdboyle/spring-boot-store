package com.carterdboyle.store.mappers;

import com.carterdboyle.store.dtos.ProductDto;
import com.carterdboyle.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source="category.id", target="categoryId")
    ProductDto toDto(Product product);
}
