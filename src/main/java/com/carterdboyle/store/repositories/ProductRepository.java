package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> { }
