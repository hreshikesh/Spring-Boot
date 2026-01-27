package com.xworkz.cinexa.repository;

import com.xworkz.cinexa.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
}
