package com.xworkz.cinexa.restcontroller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinexa")
public class CinexaRestController {


    @PostMapping("/logout")
    public void logOut(HttpSession httpSession){
        httpSession.invalidate();
    }
}
