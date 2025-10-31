package com.carterdboyle.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "users")
@NoArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(
            name="user_tags",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE
            },
            orphanRemoval = true
    )
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="wishlist",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    @Builder.Default
    private Set<Product> wishlist = new HashSet<>();

     //Comment out to remove relationship
//     @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
//     private Profile profile;

    public void addTag(String tagName) {
        var tag = new Tag(tagName);
        tags.add(tag);
        tag.getUsers().add(this);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
