package com.xworkz.cinexa.service;

import org.springframework.stereotype.Service;


public interface AdminService {

    String findByEmail(String email);

    String generateOtp(String email);
}
