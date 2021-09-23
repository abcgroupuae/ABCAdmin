package com.aisha.ABCAdmin.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="whatsapp_click_count")
public class WhatsappClickClass {
	
	@Transient
	LocalDate fromdate;
	@Transient
	LocalDate todate;
	
	@Id
	@Column(name="sl_no")
	private int slno;
	@Column(name="count")
	private int count;
	@Column(name="date")
	private LocalDate clickdate;
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public LocalDate getClickdate() {
		return clickdate;
	}
	public void setClickdate(LocalDate clickdate) {
		this.clickdate = clickdate;
	}
	
	public LocalDate getFromdate() {
		return fromdate;
	}
	public void setFromdate(LocalDate fromdate) {
		this.fromdate = fromdate;
	}
	public LocalDate getTodate() {
		return todate;
	}
	public void setTodate(LocalDate todate) {
		this.todate = todate;
	}
	public WhatsappClickClass(int slno, int count, LocalDate clickdate) {
		super();
		this.slno = slno;
		this.count = count;
		this.clickdate = clickdate;
	}
	@Override
	public String toString() {
		return "WhatsappClickClass [slno=" + slno + ", count=" + count + ", clickdate=" + clickdate + ", getSlno()="
				+ getSlno() + ", getCount()=" + getCount() + ", getClickdate()=" + getClickdate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public WhatsappClickClass() {
		
	}
	
}
