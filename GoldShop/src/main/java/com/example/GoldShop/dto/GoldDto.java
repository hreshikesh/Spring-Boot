package com.example.GoldShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoldDto {
    private String goldOrnamentName;
    private int goldPrice;
    private  String company;
    private String dealer;
}
