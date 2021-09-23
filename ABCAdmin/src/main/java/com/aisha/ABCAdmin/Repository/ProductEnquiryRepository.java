package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.ProductEnquiry;
@Repository
public interface ProductEnquiryRepository extends JpaRepository<ProductEnquiry, Integer> {

}
