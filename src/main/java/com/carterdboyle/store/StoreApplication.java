package com.carterdboyle.store;

import com.carterdboyle.store.entities.Category;
import com.carterdboyle.store.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var service = context.getBean(ProductService.class);

        service.fetchProductsBySpecification(new Category((byte) 1));
    }
}
