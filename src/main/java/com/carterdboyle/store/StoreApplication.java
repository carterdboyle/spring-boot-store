package com.carterdboyle.store;

import com.carterdboyle.store.entities.User;
import com.carterdboyle.store.repositories.UserRepository;
import com.carterdboyle.store.services.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

    static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.register(new User(1L, "test@example.com", "password123", "John Smith"));
    }

}
