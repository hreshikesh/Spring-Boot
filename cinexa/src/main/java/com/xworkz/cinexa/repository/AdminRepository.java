package com.xworkz.cinexa.repository;

import com.xworkz.cinexa.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer> {

    Optional<AdminEntity> findByadminEmail(String adminEmail);
}
