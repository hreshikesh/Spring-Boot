package com.example.GoldShop.service;

import com.example.GoldShop.dto.GoldDto;

public interface GoldService {
    String saveGold(GoldDto dto);

    GoldDto getGoldDetailsById(int id);
}
