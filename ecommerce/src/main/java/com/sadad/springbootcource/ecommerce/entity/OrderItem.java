package com.sadad.springbootcource.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;


//@Data
@Getter
@Setter
@EqualsAndHashCode(exclude = {"order","product"})
@ToString(exclude = {"order","product"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_order_item")
@Entity
//@Audited

public class OrderItem {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;
    private String  productName;
    private Integer quantity;
    private Double price;


     @ManyToOne
     @JoinColumn(name = "order_id",referencedColumnName = "id")
     @JsonBackReference("orderItems")
     private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
  //  @JsonBackReference
    private Product product;



}

