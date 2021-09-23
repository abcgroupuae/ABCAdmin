package com.aisha.ABCAdmin.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="enquired_product")
public class ProductEnquiry {
	@Id
	int slno;
	@Column(name="customer_mailid")
	String mailId;
	@Column(name="customer_name")
	String customerName;
	@Column(name="product_id")
	String productId;
	@Column(name="customer_phoneno")
	String phone;
	@Column(name="date")
	LocalDate date;
	
	@Transient
	String fromdate;
	@Transient
	String todate;
	
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
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ProductEnquiry() {
		
	}
	public ProductEnquiry(int slno, String mailId, String customerName, String productId, String phone,
			LocalDate date) {
		super();
		this.slno = slno;
		this.mailId = mailId;
		this.customerName = customerName;
		this.productId = productId;
		this.phone = phone;
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProductEnquiry [slno=" + slno + ", mailId=" + mailId + ", customerName=" + customerName + ", productId="
				+ productId + ", phone=" + phone + ", date=" + date + "]";
	}
	
	
	

}
