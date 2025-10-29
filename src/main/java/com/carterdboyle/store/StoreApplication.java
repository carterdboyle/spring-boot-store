package com.carterdboyle.store;

import com.carterdboyle.store.entities.Category;
import com.carterdboyle.store.entities.Product;
import com.carterdboyle.store.entities.Profile;
import com.carterdboyle.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

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

        var product = new Product();
        product.setId(1L);
        product.setName("Screwdriver");
        product.setPrice(new BigDecimal("10.12"));

        var category = new Category();
        category.setId((byte) 1);
        category.setName("Tools and Hardware");

        product.setCategory(category);

        user.addTag("tag1");
        System.out.println(user);
        System.out.println(product);

    }

}
