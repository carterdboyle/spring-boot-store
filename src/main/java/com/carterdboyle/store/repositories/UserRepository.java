package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
