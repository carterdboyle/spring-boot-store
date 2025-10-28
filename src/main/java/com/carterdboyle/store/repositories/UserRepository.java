package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.User;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
