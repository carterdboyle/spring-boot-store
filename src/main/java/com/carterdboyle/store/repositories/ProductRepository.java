package com.carterdboyle.store.repositories;

import com.carterdboyle.store.dtos.ProductSummary;
import com.carterdboyle.store.dtos.ProductSummaryDto;
import com.carterdboyle.store.entities.Category;
import com.carterdboyle.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // String - want to use like in SQL
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    //Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    // Multiple Conditions
    List<Product> findByDescriptionNullAndNameNull();

    // Sort (order by)
    List<Product> findByNameOrderByPrice(String name);
    List<Product> findByNameOrderByPriceAsc(String name);

    // Limit (Top/First)
    List<Product> findTop5ByNameOrderByPrice(String name);
    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find products whose prices are in a given range and sort by name
    // SQL or JPQL (database agnostic - does not have all modern SQL features
    // but it is portable)
    // SQL ---
    //    @Query(
//            value = "select * from products p where p.price between :min and :max order by p.name",
//            nativeQuery = true)
    // JPQL ---
//    @Query(
//           "select p from Product p where p.price between :min and :max order by p.name"
//    )
    @Query("select p from Product p join p.category where p.price between :min and :max order by p.price")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);

    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummaryDto> findByCategory(@Param("category") Category category);
}
