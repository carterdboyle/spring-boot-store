package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
