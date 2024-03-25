package com.sadad.springbootcource.ecommerce.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.util.List;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_category")
//@Audited

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String categoryName;

    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_category_product",
    joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"),
    inverseJoinColumns=@JoinColumn(name = "product_id",referencedColumnName = "id")
    )
    private List<Product> products;





}
