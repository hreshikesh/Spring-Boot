package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.service.AdminService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/Admin")
public class AdminRestController {


    private final AdminService adminService;

    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/sentOtp/{adminEmail}")
    public ResponseEntity<String> verifyAndSendOtp(@PathVariable String adminEmail, HttpSession httpSession){

       String result= adminService.findByEmail(adminEmail);
       if(result.equals("Notfound")){
           return ResponseEntity.badRequest().body("Email Not Found");
       }else{
           httpSession.setAttribute("adminEmail",adminEmail);
           String otp=adminService.generateOtp(adminEmail);
            return ResponseEntity.ok("OTP Sent to Your Registered Mail");
       }

    }

}
