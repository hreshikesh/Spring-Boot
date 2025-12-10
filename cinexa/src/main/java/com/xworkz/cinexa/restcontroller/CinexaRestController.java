package com.xworkz.cinexa.restcontroller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinexa")
@Slf4j
public class CinexaRestController {


    @PostMapping("/logout")
    public void logOut(HttpSession httpSession){
        log.info("entered logout method");
        httpSession.invalidate();
    }

}
