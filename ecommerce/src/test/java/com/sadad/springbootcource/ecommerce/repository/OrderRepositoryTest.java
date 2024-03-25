package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.*;
import com.sadad.springbootcource.ecommerce.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Test
    void saveOrder() {
//        Order order = new Order(null, LocalDateTime.now(), 100D, null,null);
        Customer customer=new Customer();
        customer.setId(65L);



        Order order= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(100D)
                .customer(customer)
                .build();

        Product product2= Product.builder()
                .id(2L)
                .build();
        Product product1= Product.builder()
                .id(1L)
                .build();

        OrderItem orderItem= OrderItem.builder()
                .productName("product1")
                .price(10D)
                .quantity(1)
                .order(order)
                .product(product1)
                .build();


        OrderItem orderItem2= OrderItem.builder()
                .productName("product2")
                .price(10D)
                .quantity(1)
                .order(order)
                .product(product2)
                .build();

        List<OrderItem> orderItems=new ArrayList<>();
        orderItems.add(orderItem);
        orderItems.add(orderItem2);
        order.setOrderItems(new ArrayList<>());
        order.setOrderItems(orderItems);


        ShippingAddress shippingAddress= ShippingAddress.builder()
                .city("Tehran")
                .state("Tehran")
                .street("Valisar")
                .zipCode("123456789")
                .order(order)
                .build();
        order.setShippingAddress(shippingAddress);
        orderRepository.save(order);
    }



    @Test
    void saveOrderWithCustomerActivityLog() throws Exception {

        orderService.saveOrderWithCustomerActivityLog(null);

    }
}