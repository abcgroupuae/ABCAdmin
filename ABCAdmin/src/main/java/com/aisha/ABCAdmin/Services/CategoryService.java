package com.aisha.ABCAdmin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.Categories;
import com.aisha.ABCAdmin.Repository.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Categories> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Categories> findByCategoryId(String id) {
		return categoryRepository.findById(id);
	}
	
	
	public Categories saveCategory(Categories newCategory,HttpSession session) {
		System.out.println("From value"+newCategory.getFromValue());
		newCategory.setUpdated_at(LocalDateTime.now());
		newCategory.setUpdated_by(session.getAttribute("userId").toString());
		if(!categoryRepository.findById(newCategory.getCategory_ID()).isPresent()) {
			 newCategory.setCreated_at(LocalDateTime.now());
			 newCategory.setCreated_by( session.getAttribute("userId").toString());
		}else {
			Categories existingCategory = categoryRepository.findById(newCategory.getCategory_ID()).get();
			 newCategory.setCreated_at(existingCategory.getCreated_at());
			 newCategory.setCreated_by( existingCategory.getCreated_by());
		}
		
//		if(newCategory.getFromValue().equalsIgnoreCase("Add") ) {
//			newCategory.setCreated_at(LocalDateTime.now());
//			newCategory.setUpdated_at(LocalDateTime.now());
//			newCategory.setCreated_by(session.getAttribute("userId").toString());
//			newCategory.setUpdated_by(session.getAttribute("userId").toString());
//			System.out.println("Created At"+newCategory.getCreated_at());
//		}else {
//			newCategory.setUpdated_at(LocalDateTime.now());
//			newCategory.setUpdated_by(session.getAttribute("userId").toString());
//			if(!categoryRepository.findById(newCategory.getCategory_ID()).isPresent()) {
//				 newCategory.setCreated_at(LocalDateTime.now());
//				 newCategory.setCreated_by( session.getAttribute("userId").toString());
//			}
//			   
////			System.out.println(newCategory.getFromValue()+" and created at"+ newCategory.getCreated_at());
//		}
		return categoryRepository.save(newCategory);
	}
	
	
	public void deleteCategory(String CatId) {
		categoryRepository.deleteById(CatId);
	}

}
