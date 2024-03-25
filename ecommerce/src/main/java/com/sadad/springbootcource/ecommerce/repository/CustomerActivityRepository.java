package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.CustomerActivity;
import com.sadad.springbootcource.ecommerce.entity.Inventory;
import com.sadad.springbootcource.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerActivityRepository extends JpaRepository<CustomerActivity,Long> {

}







