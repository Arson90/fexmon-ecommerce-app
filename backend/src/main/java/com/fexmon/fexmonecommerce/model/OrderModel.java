package com.fexmon.fexmonecommerce.model;

import com.fexmon.fexmonecommerce.enumeration.PaymentType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    private String customerName;
    private String email;
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressModel address;
    private String country;
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
}
