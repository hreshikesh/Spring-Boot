package com.xworkz.laptop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDto {
    private int id;
    private  String laptopName;
    private int laptopPrice;
    private String laptopBrand;
    private String ownerName;
}
