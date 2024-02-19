package com.sadad.springbootcource.ecommerce.service;



import com.sadad.springbootcource.ecommerce.entity.Customer;
import com.sadad.springbootcource.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;




    public List<Customer> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers;
    }

    public Customer get(Long id) {
        return customerRepository.findById(id).get();

    }

    public Long create(Customer customer) {
        return customerRepository.save(customer).getId();
    }

    public List<Customer> getCustomerByEmailNamedParam(String email) {
        List<Customer> customers = customerRepository.getCustomerByEmailNamedParam(email);
        return customers;
    }

    @Transactional
    public int updateCustomerNameByEmailNative(String firstName,String email) {
        int  updatedCount=customerRepository.updateCustomerNameByEmailNative(firstName,email);
        return updatedCount;
    }




}
