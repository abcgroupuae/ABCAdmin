package com.aisha.ABCAdmin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.Categories;
import com.aisha.ABCAdmin.Entity.SubCategory;
import com.aisha.ABCAdmin.Entity.SubCategoryIdentity;
import com.aisha.ABCAdmin.Repository.SubCategoryRepository;


@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	
	public List<SubCategory> getAllSubCategory(){
		return subCategoryRepository.findAll();
	}
	
	public Optional<SubCategory> findBySubCategoryIdentity(String catid, String subcatid){
		
		return subCategoryRepository.findById(new SubCategoryIdentity(catid,subcatid));
	}
	
	public SubCategory saveSubCategory(SubCategory newSubCategory, HttpSession session) {
//		if(newSubCategory.getFromValue().equalsIgnoreCase("Add")) {
//			newSubCategory.setCreated_at(LocalDateTime.now());
//			newSubCategory.setUpdated_at(LocalDateTime.now());
//		}else {
			newSubCategory.setUpdated_at(LocalDateTime.now());
			newSubCategory.setUpdated_by(session.getAttribute("userId").toString());
			if(!subCategoryRepository.findById(newSubCategory.getSubCategoryIdentity()).isPresent()) {
				 newSubCategory.setCreated_at(LocalDateTime.now());
				 newSubCategory.setCreated_by(session.getAttribute("userId").toString());
			}else {
				SubCategory existingCategory = subCategoryRepository.findById(newSubCategory.getSubCategoryIdentity()).get();
				newSubCategory.setCreated_at(existingCategory.getCreated_at());
				newSubCategory.setCreated_by( existingCategory.getCreated_by());
			}
		return subCategoryRepository.save(newSubCategory);
	}
	public void deleteSubCategory(String CatId, String Subcatid) {
		subCategoryRepository.deleteById(new SubCategoryIdentity(CatId, Subcatid));
	}
	public List<SubCategory> getAllSubCategoryOfSelected(String catid ){
		return subCategoryRepository.findAll().stream().filter(t->t.getSubCategoryIdentity().Category_ID.equalsIgnoreCase(catid)).collect(Collectors.toList());
	}
	
}
