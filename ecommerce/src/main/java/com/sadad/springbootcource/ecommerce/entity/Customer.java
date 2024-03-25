package com.sadad.springbootcource.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sadad.springbootcource.ecommerce.config.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;
import java.util.Objects;


//@Data
@Getter
@Setter
@EqualsAndHashCode(exclude = "orders")
@ToString(exclude = "orders")
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
//@Audited
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String firstName;
    private String lastName;

    @Column(name = "email_address",
            nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id",referencedColumnName = "id" ,nullable = false)
    @JsonManagedReference
    private List<Order> orders;

}






