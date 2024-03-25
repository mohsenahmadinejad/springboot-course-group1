package com.sadad.springbootcource.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sadad.springbootcource.ecommerce.config.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;


//@Data
@Getter
@Setter
@ToString(exclude = {"customer","orderItems","shippingAddress"})
@EqualsAndHashCode(exclude = {"customer","orderItems","shippingAddress"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_order")
@Entity
//@Audited
public class Order  extends Auditable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;


     @ManyToOne
     @JoinColumn(name = "fk_customer_id",referencedColumnName = "id")
     @JsonBackReference
     private Customer customer;


    @OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "orderItems")
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "shippingAddress")
    private ShippingAddress shippingAddress;

}

