package com.aisha.ABCAdmin.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.ABCAdmin.Entity.WhatsappClickClass;
import com.aisha.ABCAdmin.Repository.whatsappClickRepository;



@Service
public class GenericService {
	@Autowired
	private whatsappClickRepository whatsappRepository;
	
	
	public List<WhatsappClickClass> getAllWhatsappClicks(){
		return whatsappRepository.findAll();
	}
	
//	public List<WhatsappClickClass> getAllDates(){
//		return whatsappRepository.findAllByClickdate();
//	}
}
