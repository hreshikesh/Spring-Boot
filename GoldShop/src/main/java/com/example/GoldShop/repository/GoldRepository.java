package com.example.GoldShop.repository;

import com.example.GoldShop.entity.GoldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface GoldRepository extends JpaRepository<GoldEntity,Integer> {

    List<GoldEntity> findByCompany(String companyName);

    @Query("select e.dealer from GoldEntity e where e.company = :companyName")
    String findDealerNameByCompany(@Param("companyName") String companyName);


}
