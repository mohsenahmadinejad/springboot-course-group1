package com.sadad.springbootcource.ecommerce.repository;

import com.sadad.springbootcource.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByFirstNameContaining(String s);
    public List<Customer> findByFirstNameAndLastName(String firstName,String LastName);

    //JPQL
    @Query("select c from Customer c  where c.email= ?1")
    public List<Customer> getCustomerByEmail(String email);


    //native
    @Query(value = "select c.* from tbl_customer c  where c.email_address= ?1",
          nativeQuery = true)
    public List<Customer> getCustomerByEmailNative(String email);


    //JPQL named param
    @Query("select c from Customer c  where c.email= :email ")
    public List<Customer> getCustomerByEmailNamedParam(@Param("email") String email                                                       );

    @Query(value = "select c.* from tbl_customer c  where c.email_address= :email",
            nativeQuery = true)
    public List<Customer> getCustomerByEmailNativeNamedParam(@Param("email") String email);



    @Modifying
    @Query(value = "update tbl_customer c  set c.first_name= ?1 where c.email_address=?2",
            nativeQuery = true)
    public int updateCustomerNameByEmailNative(String firstName, String email);



}







