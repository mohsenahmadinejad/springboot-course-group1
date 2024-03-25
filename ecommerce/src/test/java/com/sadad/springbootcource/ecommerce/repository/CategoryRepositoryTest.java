package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.Category;
import com.sadad.springbootcource.ecommerce.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    void saveCategory() {

        Product product2 = Product.builder()
                .productName("product2")
                .unitPrice(10D)
                .description("this is product2")
                .build();
        Product product3 = Product.builder()
                .productName("product3")
                .unitPrice(10D)
                .description("this is product3")
                .build();

        Category category = Category.builder()
                .categoryName("category1")
                .build();

        List<Product> products = new ArrayList<>();
        products.add(product2);
        products.add(product3);
        category.setProducts(products);

        repository.save(category);

    }
}