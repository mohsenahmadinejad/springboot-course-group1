package com.sadad.springbootcource.ecommerce.service;

import com.sadad.springbootcource.ecommerce.entity.Inventory;
import com.sadad.springbootcource.ecommerce.entity.Product;
import com.sadad.springbootcource.ecommerce.exception.InsufficientInventoryException;
import com.sadad.springbootcource.ecommerce.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public boolean checkAvailability(Product product, int quantity) {
        Inventory inventory = inventoryRepository.findByProduct(product);
        return inventory != null && inventory.getQuantity() >= quantity;
    }


    public void deductInventory(Product product, int quantity) throws Exception {
        Inventory inventory = inventoryRepository.findByProduct(product);
        if (inventory != null && inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
        } else {
            throw new InsufficientInventoryException("Insufficient inventory for product: " + product.getProductName());
          //   throw new Exception("");
        }
    }

    @Transactional()
    public void addInventory(Product product, int quantity) {
        Inventory inventory = inventoryRepository.findByProduct(product);
        if (inventory != null) {
            inventory.setQuantity(inventory.getQuantity() + quantity);
        } else {
            inventory = new Inventory();
            inventory.setProduct(product);
            inventory.setQuantity(quantity);
        }
        inventoryRepository.save(inventory);
    }
}
