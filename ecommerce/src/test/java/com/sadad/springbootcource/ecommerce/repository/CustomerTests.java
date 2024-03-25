package com.sadad.springbootcource.ecommerce.repository;


import com.sadad.springbootcource.ecommerce.entity.Customer;
import com.sadad.springbootcource.ecommerce.entity.Order;
import com.sadad.springbootcource.ecommerce.repository.CustomerRepository;
import com.sadad.springbootcource.ecommerce.rest.CustomerResource;
import com.sadad.springbootcource.ecommerce.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    void saveCustomer() {

//        Customer customer=new Customer(null,"Ali","mohamadi","ali@gmail.com");
        Customer customer=Customer.builder()
                .firstName("ali")
                .lastName("mohamadi")
                .email("ali@gmail.com")
                .build();
        customerRepository.save(customer);

    }

    @Test
    void saveAllCustomer() {

        List<Customer> customers=new ArrayList<>();
        customers.add(new Customer(21L,"Ali","Ahmadi","ali21@gmail.com",null));
        customers.add(new Customer(22L,"Ali2","Ahmadi2","ali22@gmail.com",null));
        customers.add(new Customer(23L,"Ali3","Ahmadi3","ali23@gmail.com",null));
        customerRepository.saveAll(customers);


        System.out.println();


    }

    @Test
    void updateCustomer() {
        Customer customer=new Customer(2L,"Ali","mohamadi222","ali@gmail.com",null);
        customerRepository.save(customer);
    }

    @Test
    void deleteCustomer() {

        customerRepository.deleteById(1L);
    }


    @Test
    void findById() {
        System.out.println(customerRepository.findById(2L));
    }

    @Test
    void findAll() {
        List<Customer> customers=customerRepository.findAll();
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void findByFirstName() {
        List<Customer> customers=customerRepository.findByFirstName("Ali");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void findByFirstNameContaining() {
        List<Customer> customers=customerRepository.findByFirstNameContaining("m");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void findByFirstNameAndLastName() {
        List<Customer> customers=customerRepository.findByFirstNameAndLastName("ali","Doe");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void getCustomerByEmail() {
        List<Customer> customers=customerRepository.getCustomerByEmail("emma.brown@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }
    @Test
    void getCustomerByEmailNative() {
        List<Customer> customers=customerRepository.getCustomerByEmailNative("emma.brown@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void getCustomerByEmailNamedParam() {
        List<Customer> customers=customerRepository.getCustomerByEmailNamedParam("emma.brown@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void getCustomerByEmailNativeNamedParam() {
        List<Customer> customers=customerRepository.getCustomerByEmailNativeNamedParam("emma.brown@example.com");
        customers.forEach(customer -> System.out.println(customer));
    }

    @Test
    void updateCustomerNameByEmailNative() {
//        int  updatedCount=customerRepository.updateCustomerNameByEmailNative("alice.smith@example.com","alice.smith@example.com");
        int  updatedCount=customerService.updateCustomerNameByEmailNative("alice.smith@example.com","alice.smith@example.com");
        System.out.println(updatedCount);
    }


    @Test
    void saveCustomerWithOrders() {
//        Customer customer=new Customer(null,"mohsen","ahmadi","mohsen@gmai.com");
        Customer customer=Customer.builder()
                .firstName("ali50")
                .lastName("ahmadi50")
                .email("ali@gmail5110")
                .build();

        Order order1= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(10D)
                .build();
        Order order2= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(11D)
                .build();
        Order order3= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(12D)
                .build();

        customer.setOrders(new ArrayList<Order>());
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        customer.getOrders().add(order3);


        customerRepository.save(customer);

    }

    @Test
    @Transactional
    void getCustomerById() {
        Customer customer=customerRepository.findById(59L).get();
        System.out.println(customer.getOrders());

    }


    @Test
    void saveCustomerWithOrders2() {
//        Customer customer=new Customer(null,"mohsen","ahmadi","mohsen@gmai.com");
        Customer customer=Customer.builder()
                .firstName("mohsen50")
                .lastName("mohsen50ahmadi50")
                .email("mohsen501@gmail5110")
                .build();

        Order order1= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(100D)
                .customer(customer)
                .build();
        Order order2= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(110D)
                .customer(customer)
                .build();
        Order order3= Order.builder()
                .orderDate(LocalDateTime.now())
                .totalAmount(120D)
                .customer(customer)
                .build();

        customer.setOrders(new ArrayList<Order>());
        customer.getOrders().add(order1);
        customer.getOrders().add(order2);
        customer.getOrders().add(order3);


        customerRepository.save(customer);

    }

}
