package com.xworkz.cinexa.service;

import com.xworkz.cinexa.entity.AdminEntity;
import com.xworkz.cinexa.repository.AdminRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchedulingService {

    private final AdminRepository adminRepository;

    public SchedulingService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void checkOtpExpiry(){
        List<AdminEntity> adminEntityList=adminRepository.getAllAdminDetails();

        adminEntityList.forEach(adminEntity -> {
            if (adminEntity.getLocalDateTime()!=null && LocalDateTime.now().isAfter(adminEntity.getLocalDateTime())){
                adminEntity.setOtp(null);
                adminEntity.setLocalDateTime(null);
                adminRepository.save(adminEntity);
            }
        });
    }

}
