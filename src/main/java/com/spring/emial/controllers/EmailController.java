package com.spring.emial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emial.models.EmailRequest;
import com.spring.emial.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailservice;
	
	@GetMapping("/email")
	public String email() {
		return "this is for email";
	}
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest mail)
 	{
		System.out.println(mail);
		this.emailservice.sendEmail(mail.getto(), mail.getSubject(), mail.getMessage());
		
		return ResponseEntity.ok("done.");
	}
}
