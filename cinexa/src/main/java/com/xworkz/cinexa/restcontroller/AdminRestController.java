package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.service.AdminService;
import com.xworkz.cinexa.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/Admin")
@CrossOrigin("http://localhost:3000/")
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
       String result= adminService.findByEmail(adminEmail);
       if(result.equals("Notfound")){
           return ResponseEntity.badRequest().body("Email Not Found");
       }else{
           httpSession.setAttribute("adminEmail",adminEmail);
           String otp=adminService.generateOtp(adminEmail);
           log.info(otp);
           emailService.sendAdminOtpMail(adminEmail,otp);
            return ResponseEntity.ok("OTP Sent to Your Registered Mail");
       }

    }

    @PostMapping("/verifyotp/{adminEmail}/{otp}")
    public ResponseEntity<String> verifyOtp(@PathVariable String adminEmail,@PathVariable String otp){
       String isVerified= adminService.verifyOtp(adminEmail,otp);
        switch (isVerified){
            case "Valid":return ResponseEntity.ok("OTP Valid");
            case "NotValid":return ResponseEntity.badRequest().body("OTP invalid Check Your OTP");
            case "TimeOut":return ResponseEntity.status(408).body("OTP Timeout Please Resend Otp");
            default: return ResponseEntity.ok("Error Verifying ...Please try again later");
        }
    }

}
