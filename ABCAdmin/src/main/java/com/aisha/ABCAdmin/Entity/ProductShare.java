package com.aisha.ABCAdmin.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="whatsapp_share_count")
public class ProductShare {
	@Id
	int slno;
	@Column(name="product_id")
	String productId;
	@Column(name="social_media")
	String socialMedia;
	int count;
	LocalDate date;
	
	@Transient
	String fromdate;
	@Transient
	String todate;
	@Transient
	LocalDate lfromdate;
	@Transient
	LocalDate ltodate;
	
	
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public LocalDate getLfromdate() {
		return lfromdate;
	}
	public void setLfromdate(LocalDate lfromdate) {
		this.lfromdate = lfromdate;
	}
	public LocalDate getLtodate() {
		return ltodate;
	}
	public void setLtodate(LocalDate ltodate) {
		this.ltodate = ltodate;
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(String socialMedia) {
		this.socialMedia = socialMedia;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ProductShare() {
		
	}
	public ProductShare(int slno, String productId, String socialMedia, int count, LocalDate date) {
		super();
		this.slno = slno;
		this.productId = productId;
		this.socialMedia = socialMedia;
		this.count = count;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProductShare [slno=" + slno + ", productId=" + productId + ", socialMedia=" + socialMedia + ", count="
				+ count + ", date=" + date + "]";
	}
	

}
