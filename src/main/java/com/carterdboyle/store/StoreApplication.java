package com.carterdboyle.store;

import com.carterdboyle.store.entities.Profile;
import com.carterdboyle.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    static void main(String[] args) {
//        SpringApplication.run(StoreApplication.class, args);

        var user = User.builder()
                .name("Carter")
                .password("password")
                .email("carter@example.com")
                .build();

        var profile = Profile.builder()
                        .bio("bio")
                        .build();

        user.setProfile(profile);
        profile.setUser(user);

        user.addTag("tag1");
        System.out.println(user);

    }

}
