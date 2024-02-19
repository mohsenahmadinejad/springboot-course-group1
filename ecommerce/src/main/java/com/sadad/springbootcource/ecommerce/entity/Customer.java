package com.sadad.springbootcource.ecommerce.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_customer"
        ,
        uniqueConstraints =@UniqueConstraint(
                name = "email_enique",
                columnNames = "email_address"
        )
)
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false)
    private String email;
}