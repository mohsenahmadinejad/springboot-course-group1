package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.Category;
import com.sadad.springbootcource.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}







