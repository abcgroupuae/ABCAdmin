package com.aisha.ABCAdmin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.ABCAdmin.Entity.WhatsappClickClass;


@Repository
public interface whatsappClickRepository extends JpaRepository<WhatsappClickClass, Integer> {

	
		
}
