package com.fexmon.fexmonecommerce.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ProductModel> productModelSet;
    private double totalPrice;
    private int quantity;

    public CartModel(Set<ProductModel> productModelSet, double totalPrice, int quantity) {
        this.productModelSet = productModelSet;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }
}
