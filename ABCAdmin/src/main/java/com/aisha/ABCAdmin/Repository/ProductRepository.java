package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
