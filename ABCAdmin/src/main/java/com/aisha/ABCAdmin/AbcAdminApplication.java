package com.aisha.ABCAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AbcAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbcAdminApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("manal"));
	}

}
