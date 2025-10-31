package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    // Can expressly eager load certain attributes
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);
}
