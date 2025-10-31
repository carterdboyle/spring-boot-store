package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Long> { }
