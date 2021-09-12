package com.aisha.ABCAdmin.Entity;


import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="sub_categories")
public class SubCategory {
	
	@EmbeddedId
	@Valid
	SubCategoryIdentity subCategoryIdentity;
	
    
	@NotNull(message=" is required")
	public String Sub_Category_Name;
   
    
	@NotNull(message=" is required")
	public String Description;
   
    
	@NotNull(message=" is required")
	public String Status;
	private LocalDateTime updated_at;
	private LocalDateTime created_at;
	private String updated_by;
	private String created_by;
	
	
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public SubCategoryIdentity getSubCategoryIdentity() {
		return subCategoryIdentity;
	}
	public void setSubCategoryIdentity(SubCategoryIdentity subCategoryIdentity) {
		this.subCategoryIdentity = subCategoryIdentity;
	}
	public String getSub_Category_Name() {
		return Sub_Category_Name;
	}
	public void setSub_Category_Name(String sub_Category_Name) {
		Sub_Category_Name = sub_Category_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	
	public SubCategory(@Valid SubCategoryIdentity subCategoryIdentity,
			@NotNull(message = " is required") String sub_Category_Name,
			@NotNull(message = " is required") String description, @NotNull(message = " is required") String status,
			LocalDateTime updated_at, LocalDateTime created_at, String updated_by, String created_by,
			Categories categories, String fromValue) {
		super();
		this.subCategoryIdentity = subCategoryIdentity;
		Sub_Category_Name = sub_Category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
		this.updated_by = updated_by;
		this.created_by = created_by;
		this.categories = categories;
		FromValue = fromValue;
	}
	public SubCategory() {
		
	}
	
	
	///////////
	//out of DB Values
	////////////////////
	@Transient
	@Autowired
	Categories categories;
	
	// non db field //
		@Transient
		private String FromValue;
		public String getFromValue() {
			return FromValue;
		}
		public void setFromValue(String fromValue) {
			FromValue = fromValue;
		}
	
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public void setCategories(Optional<Categories> categories) {
		this.categories = categories.get();
	}
	
	
	
}
