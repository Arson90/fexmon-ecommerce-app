package com.fexmon.fexmonecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String productName;
    private double price;
}
