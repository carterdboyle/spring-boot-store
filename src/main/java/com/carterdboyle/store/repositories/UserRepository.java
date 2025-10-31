package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
