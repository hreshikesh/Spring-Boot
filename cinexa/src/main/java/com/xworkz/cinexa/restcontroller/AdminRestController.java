package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.service.AdminService;
import com.xworkz.cinexa.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeoutException;

@RestController
@Slf4j
@RequestMapping("/api/Admin")
public class AdminRestController {


    private final AdminService adminService;

    private final EmailService emailService;

    public AdminRestController(AdminService adminService, EmailService emailService) {
        this.adminService = adminService;
        this.emailService = emailService;
    }

    @PostMapping("/sentOtp/{adminEmail}")
    public ResponseEntity<String> verifyAndSendOtp(@PathVariable String adminEmail, HttpSession httpSession) throws MessagingException {
       if(adminEmail==null || adminEmail.isBlank()){
           return  ResponseEntity.badRequest().body("Please Enter Email to proceed");
       }
       adminService.findByEmail(adminEmail);

           httpSession.setAttribute("adminEmail",adminEmail);
           String otp=adminService.generateOtp(adminEmail);
           log.info(otp);
           emailService.sendAdminOtpMail(adminEmail,otp);
            return ResponseEntity.ok("OTP Sent to Your Registered Mail");
    }

    @PostMapping("/verifyotp/{adminEmail}/{otp}")
    public ResponseEntity<String> verifyOtp(@PathVariable String adminEmail,@PathVariable String otp) throws TimeoutException {
       String isVerified= adminService.verifyOtp(adminEmail,otp);
        switch (isVerified){
            case "Valid":return ResponseEntity.ok("OTP Valid");
            case "NotValid":return ResponseEntity.badRequest().body("OTP invalid Check Your OTP");
            default: return ResponseEntity.ok("Error Verifying ...Please try again later");
        }
    }

}
