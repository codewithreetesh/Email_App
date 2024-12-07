package com.spring.emial.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender; // केवल JavaMailSender को Autowire करें

    public void sendEmail(String to, String subject, String message) {
        try {
            // ईमेल संदेश तैयार करें
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(message);
            email.setFrom("kumarreetesh9799@gmail.com"); 

            // ईमेल भेजें
            mailSender.send(email);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send email.");
        }
    }
}
