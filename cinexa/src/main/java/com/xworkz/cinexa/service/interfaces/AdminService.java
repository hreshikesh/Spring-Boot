package com.xworkz.cinexa.service.interfaces;

import java.util.concurrent.TimeoutException;


public interface AdminService {

    String findByEmail(String email);

    String generateOtp(String email);

    String  verifyOtp(String email,String otp) throws TimeoutException;
}
