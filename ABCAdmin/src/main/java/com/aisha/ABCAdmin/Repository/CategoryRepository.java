package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.Categories;


@Repository
public interface CategoryRepository extends JpaRepository<Categories, String>{

}
