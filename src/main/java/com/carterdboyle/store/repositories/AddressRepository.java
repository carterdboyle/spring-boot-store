package com.carterdboyle.store.repositories;

import com.carterdboyle.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
