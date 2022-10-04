package com.fexmon.fexmonecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    private String streetName;
    private String streetNumber;
    private String town;
    private String postalCode;
}
