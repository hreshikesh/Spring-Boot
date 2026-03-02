package com.xworkz.cinexa.service.implementation;

import com.xworkz.cinexa.entity.AdminEntity;
import com.xworkz.cinexa.repository.AdminRepository;
import com.xworkz.cinexa.service.interfaces.AdminService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

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

        Random random = new Random();
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <6 ; i++) {
            builder.append(random.nextInt(10));
        }


        String otp= builder.toString();
        Optional<AdminEntity> adminEntity=adminRepository.findByadminEmail(email);
        if(adminEntity.isPresent()) {
            adminEntity.get().setOtp(otp);
            adminEntity.get().setLocalDateTime(LocalDateTime.now().plusMinutes(2));
            adminRepository.save(adminEntity.get());
        }
      return otp;
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
