package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.Inventory;
import com.sadad.springbootcource.ecommerce.entity.OrderItem;
import com.sadad.springbootcource.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    public Inventory findByProduct(Product product);
}







