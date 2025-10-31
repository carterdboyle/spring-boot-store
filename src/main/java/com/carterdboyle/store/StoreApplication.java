package com.carterdboyle.store;

import com.carterdboyle.store.services.ProductService;
import com.carterdboyle.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service = context.getBean(UserService.class);
        service.fetchUser();
    }
}
