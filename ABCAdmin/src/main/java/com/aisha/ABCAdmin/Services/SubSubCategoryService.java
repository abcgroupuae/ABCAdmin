package com.aisha.ABCAdmin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.SubCategory;
import com.aisha.ABCAdmin.Entity.SubSubCategory;
import com.aisha.ABCAdmin.Entity.SubSubCategoryIdentity;
import com.aisha.ABCAdmin.Repository.SubSubCategoryRepository;



@Service
public class SubSubCategoryService {
	@Autowired
	SubSubCategoryRepository subSubCategoryRepository;
	
	public List<SubSubCategory> getAllSubSubCategories(){
		return subSubCategoryRepository.findAll();
	}
	
	public Optional<SubSubCategory> findBySubSubCategoryIdentity(String catid, String subcatid, String subsubcatid){
		
		return subSubCategoryRepository.findById( new SubSubCategoryIdentity(catid, subcatid, subsubcatid));
	}

	public SubSubCategory saveSubCategory(SubSubCategory newSubCategory,HttpSession session) {
		newSubCategory.setUpdated_at(LocalDateTime.now());
		newSubCategory.setUpdated_by(session.getAttribute("userId").toString());
		if(!subSubCategoryRepository.findById(newSubCategory.getSubSubCategoryIdentity()).isPresent()) {
			 newSubCategory.setCreated_at(LocalDateTime.now());
			 newSubCategory.setCreated_by(session.getAttribute("userId").toString());
		}else {
			SubSubCategory existingCategory = subSubCategoryRepository.findById(newSubCategory.getSubSubCategoryIdentity()).get();
			newSubCategory.setCreated_at(existingCategory.getCreated_at());
			newSubCategory.setCreated_by( existingCategory.getCreated_by());
		}
		return subSubCategoryRepository.save(newSubCategory);
		
	}
	public void deleteSubSubCategory(String catid, String subcatid, String subsubcatid) {
		subSubCategoryRepository.deleteById(new SubSubCategoryIdentity(catid, subcatid, subsubcatid));;
	}
	
	public List<SubSubCategory> getAllSubSubCategoryOfSelected(String catid , String subcatid ){
		return subSubCategoryRepository.findAll().stream().filter(t->((t.getSubSubCategoryIdentity().getCategory_ID().equalsIgnoreCase(catid))&&(t.getSubSubCategoryIdentity().getSub_Category_ID().equalsIgnoreCase(subcatid)))).collect(Collectors.toList());
	}
}
