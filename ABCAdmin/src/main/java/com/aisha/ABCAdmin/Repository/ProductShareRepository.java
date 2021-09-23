package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.ProductShare;
@Repository
public interface ProductShareRepository extends JpaRepository<ProductShare, Integer>{

}
