package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.SubSubCategory;
import com.aisha.ABCAdmin.Entity.SubSubCategoryIdentity;
@Repository
public interface SubSubCategoryRepository extends JpaRepository<SubSubCategory, SubSubCategoryIdentity> {

}
