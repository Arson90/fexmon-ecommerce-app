package com.fexmon.fexmonecommerce.model;

import com.fexmon.fexmonecommerce.enumeration.PaymentType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String email;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private AddressModel address;
    private String country;
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;
}