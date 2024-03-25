package com.sadad.springbootcource.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;


//@Data
@Getter
@Setter
@ToString(exclude = {"order"})
@EqualsAndHashCode(exclude = {"order"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_Shipping_Address")
@Entity
//@Audited

public class ShippingAddress {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  street;
    private String  city;
    private String  state;
    private String  zipCode;


     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "order_id",referencedColumnName = "id")
     @JsonBackReference(value = "shippingAddress")
     private Order order;
}

