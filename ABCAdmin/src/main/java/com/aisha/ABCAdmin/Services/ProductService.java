package com.aisha.ABCAdmin.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.Product;
import com.aisha.ABCAdmin.Entity.SubCategory;
import com.aisha.ABCAdmin.Repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}


	public Product saveProduct(Product newProduct, HttpSession session) {
		if(newProduct.getSub_Category_ID()==null)
			newProduct.setSub_Category_ID("");
		else if(newProduct.getSub_Sub_Category_ID()==null)
			newProduct.setSub_Sub_Category_ID("");
//		if(newProduct.getFromValue().equalsIgnoreCase("Add")) {
//			newProduct.setCreated_at(LocalDateTime.now());
//			newProduct.setUpdated_at(LocalDateTime.now());
//		}else {
			newProduct.setUpdated_at(LocalDateTime.now());
			newProduct.setUpdated_by(session.getAttribute("userId").toString());
			if(!productRepository.findById(newProduct.getProduct_id()).isPresent()) {
				newProduct.setCreated_at(LocalDateTime.now());
				newProduct.setCreated_by(session.getAttribute("userId").toString());
		     }else {
		    	    Product existingProduct = productRepository.findById(newProduct.getProduct_id()).get();
		    	    newProduct.setCreated_at(existingProduct.getCreated_at());
		    	    newProduct.setCreated_by( existingProduct.getCreated_by());
				}
		System.out.println("saving record" + newProduct.toString());
		return productRepository.saveAndFlush(newProduct);
	}
	
	
	public Optional<Product> findProductById(String productId) {
		return productRepository.findById(productId);
	}
	
	public void deleteProductById(String productId) {
		productRepository.deleteById(productId);
	}

}
