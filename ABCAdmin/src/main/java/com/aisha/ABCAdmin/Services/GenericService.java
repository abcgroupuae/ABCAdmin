package com.aisha.ABCAdmin.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.ProductEnquiry;
import com.aisha.ABCAdmin.Entity.ProductShare;
import com.aisha.ABCAdmin.Entity.WhatsappClickClass;
import com.aisha.ABCAdmin.Repository.ProductEnquiryRepository;
import com.aisha.ABCAdmin.Repository.ProductShareRepository;
import com.aisha.ABCAdmin.Repository.whatsappClickRepository;



@Service
public class GenericService {
	@Autowired
	private whatsappClickRepository whatsappRepository;
	@Autowired
	ProductShareRepository productShareRepository;
	@Autowired
	ProductEnquiryRepository productEnquiryRepository;
	
	
	public List<WhatsappClickClass> getAllWhatsappClicks(){
		return whatsappRepository.findAll();
	}


	public List<WhatsappClickClass> getAllRecordsBetweenDatesGiven(LocalDate fromdate, LocalDate todate) {
		return whatsappRepository.findAll().stream().filter(t->(t.getClickdate().isAfter(fromdate) && t.getClickdate().isBefore(todate))).collect(Collectors.toList());  
		
	}


	public List<ProductShare> getShareRecords(LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return productShareRepository.findAll().stream().filter(t->(t.getDate().isAfter(fromDate) && t.getDate().isBefore(toDate))).collect(Collectors.toList());
	}


	public List<ProductEnquiry> getEnquiryRecords(LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return productEnquiryRepository.findAll().stream().filter(t->(t.getDate().isAfter(fromDate) && t.getDate().isBefore(toDate))).collect(Collectors.toList());
	}
	
//	public List<WhatsappClickClass> getAllDates(){
//		return whatsappRepository.findAllByClickdate();
//	}
}
