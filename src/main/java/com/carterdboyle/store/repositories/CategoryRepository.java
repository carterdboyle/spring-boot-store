package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
