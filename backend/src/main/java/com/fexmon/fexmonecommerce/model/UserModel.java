package com.fexmon.fexmonecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    private CartModel cart;
}
