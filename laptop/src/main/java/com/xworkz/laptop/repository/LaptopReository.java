package com.xworkz.laptop.repository;

import com.xworkz.laptop.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopReository extends JpaRepository<LaptopEntity,Integer> {



}
