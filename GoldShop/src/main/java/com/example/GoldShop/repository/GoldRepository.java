package com.example.GoldShop.repository;

import com.example.GoldShop.entity.GoldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GoldRepository extends JpaRepository<GoldEntity,Integer> {
}
