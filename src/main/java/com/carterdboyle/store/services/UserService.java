package com.carterdboyle.store.services;

import com.carterdboyle.store.entities.Address;
import com.carterdboyle.store.entities.User;
import com.carterdboyle.store.repositories.AddressRepository;
import com.carterdboyle.store.repositories.ProfileRepository;
import com.carterdboyle.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();
        if (entityManager.contains(user))
            System.out.println("persistent");
        else
            System.out.println("transient / detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("persistent");
        else
            System.out.println("transient / detached");

    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void showAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .state("state")
                .city("city")
                .zip("zip")
                .street("street")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(4L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }
}
