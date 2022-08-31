package com.fexmon.fexmonecommerce.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private double productPrice;
    private double totalPrice;
    private int quantity;
}
