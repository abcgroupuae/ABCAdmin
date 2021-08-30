package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.SubCategory;
import com.aisha.ABCAdmin.Entity.SubCategoryIdentity;



@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, SubCategoryIdentity>{

}
