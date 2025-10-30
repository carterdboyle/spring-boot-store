package com.carterdboyle.store.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "categories")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;

    @Column(name = "name")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<>();

}