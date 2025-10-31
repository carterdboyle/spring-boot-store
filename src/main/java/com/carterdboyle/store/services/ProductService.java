package com.carterdboyle.store.services;

import com.carterdboyle.store.entities.Category;
import com.carterdboyle.store.entities.Product;
import com.carterdboyle.store.repositories.CategoryRepository;
import com.carterdboyle.store.repositories.ProductRepository;
import com.carterdboyle.store.repositories.ProfileRepository;
import com.carterdboyle.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

    public void persistRelated() {
        var product = Product.builder()
                .name("Product 1")
                .description("Product 1")
                .price(new BigDecimal("100.10"))
                .build();

        var category = new Category("Category 1");

        product.addCategory(category);

        productRepository.save(product);
    }

    @Transactional
    public void createProductByCategoryId() {
        Byte id = 1;
        var category = categoryRepository.findById(id).orElseThrow();
        var product = Product.builder()
                .name("Product 2")
                .description("Product 2")
                .price(new BigDecimal("100.11"))
                .build();

        product.addCategory(category);
        productRepository.save(product);
    }

    @Transactional
    public void addAllProductsToWishlist() {
        var user = userRepository.findById(2L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addToWishlist);

        userRepository.save(user);
    }

    public void deleteProduct() {
        productRepository.deleteById(2L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)  1);
    }

    @Transactional
    public void fetchProducts() {
        var product = new Product();
        product.setName("Product");

        var matcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);


        var example = Example.of(product, matcher);
        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchProductsByCriteria() {
        var products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }
}
