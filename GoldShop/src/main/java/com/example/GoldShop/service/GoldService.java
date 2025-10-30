package com.example.GoldShop.service;

import com.example.GoldShop.dto.GoldDto;


import java.util.List;

public interface GoldService {
    String saveGold(GoldDto dto);

    GoldDto getGoldDetailsById(int id);

    List<GoldDto> findByCompany(String company);

    String findDealerNameByCompany(String companyName);

}
