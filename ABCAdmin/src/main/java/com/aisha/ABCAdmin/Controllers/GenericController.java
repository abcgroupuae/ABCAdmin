package com.aisha.ABCAdmin.Controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aisha.ABCAdmin.Entity.ProductEnquiry;
import com.aisha.ABCAdmin.Entity.ProductShare;
import com.aisha.ABCAdmin.Entity.WhatsappClickClass;
import com.aisha.ABCAdmin.Services.GenericService;

@Controller
public class GenericController {
	@Autowired
	GenericService genericService;
	
	@GetMapping("/whatsapp/click-count")
	public String getSearchedwhatsappClickCount(@ModelAttribute WhatsappClickClass searchinput, Model model) {
//		model.addAttribute("result", genericService.getAllRecordsBetweenDatesGiven(searchinput.getFromdate(),searchinput.getTodate()));
		model.addAttribute("whatsappclick", genericService.getAllRecordsBetweenDatesGiven(searchinput.getFromdate(),searchinput.getTodate()).stream().map(obj->obj.getClickdate()).collect(Collectors.toList()));
		model.addAttribute("whatsappclickcount", genericService.getAllRecordsBetweenDatesGiven(searchinput.getFromdate(),searchinput.getTodate()).stream().map(obj->obj.getCount()).collect(Collectors.toList()));
		return "test";
	}
	@GetMapping("/whatsapp")
	public String getwhatsappClickCount( Model model) {
		model.addAttribute("whatsappclick", genericService.getAllWhatsappClicks().stream().map(obj->obj.getClickdate()).collect(Collectors.toList()));
		model.addAttribute("whatsappclickcount", genericService.getAllWhatsappClicks().stream().map(obj->obj.getCount()).collect(Collectors.toList()));
		return "test";
	}
	
	@GetMapping("/product-shares")
	public String getproductshares(Model model) {
		
		model.addAttribute("productShare", new ProductShare());
		model.addAttribute("ShareList", genericService.getShareRecords(LocalDate.now().minusMonths(1),LocalDate.now()));
		return "productshare";
	}
	@PostMapping("/product-shares")
	public String getproductshares(@ModelAttribute ProductShare productShare, Model model) {
		model.addAttribute("productShare", productShare);
		
		model.addAttribute("ShareList", genericService.getShareRecords(LocalDate.parse(productShare.getFromdate(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse(productShare.getTodate(),DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		return "productshare";
	}
	
	@GetMapping("/product-enquiry")
	public String getproductenquiry(Model model) {
		
		model.addAttribute("productEnquiry", new ProductEnquiry());
		model.addAttribute("EnquiryList", genericService.getEnquiryRecords(LocalDate.now().minusMonths(1),LocalDate.now()));
		return "productEnquiry";
	}
	@PostMapping("/product-enquiry")
	public String getproductenquiry(@ModelAttribute ProductEnquiry productEnquiry, Model model) {
		model.addAttribute("productEnquiry", productEnquiry);
		
		model.addAttribute("EnquiryList", genericService.getEnquiryRecords(LocalDate.parse(productEnquiry.getFromdate(),DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse(productEnquiry.getTodate(),DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		return "productEnquiry";
	}
}
