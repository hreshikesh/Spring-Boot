package com.xworkz.cinexa.service;

import com.xworkz.cinexa.entity.AdminEntity;
import com.xworkz.cinexa.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeoutException;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public String findByEmail(String email) {
        if (adminRepository.findByadminEmail(email).isPresent()) {
            return "Found";
        } else {
             throw  new RuntimeException("Email Not Found");
        }
    }

    @Override
    public String generateOtp(String email) {
        StringBuffer otp = new StringBuffer(6);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }
        Optional<AdminEntity> adminEntity=adminRepository.findByadminEmail(email);
        AdminEntity adminEntity1=adminEntity.get();
        adminEntity1.setOtp(otp.toString());
        adminEntity1.setLocalDateTime(LocalDateTime.now().plusMinutes(2));
        adminRepository.save(adminEntity1);
        return  otp.toString();
    }

    @Override
    public String verifyOtp(String email, String otp) throws TimeoutException {
        Optional<AdminEntity> adminEntity = adminRepository.findByadminEmail(email);

            if (adminEntity.get().getLocalDateTime()!=null && LocalDateTime.now().isBefore(adminEntity.get().getLocalDateTime())) {
                if (otp.equals(adminEntity.get().getOtp())) {
                    return "Valid";
                } else {
                    return "NotValid";
                }
            } else {
                throw new TimeoutException("OTP Timeout Please Resend Otp");
            }

    }
}
