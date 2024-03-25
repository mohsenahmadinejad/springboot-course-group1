package com.sadad.springbootcource.ecommerce.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.List;


//@Data
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_product")
@Entity
//@Audited

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String productName;
    private Double unitPrice;
    private String description;


    @ManyToMany(mappedBy = "products")
    private List<Category> categories;


    @OneToOne(mappedBy = "product" )
    @JsonManagedReference(value = "inventory")
    private Inventory inventory;



}

