package com.xworkz.laptop.service;

import com.xworkz.laptop.dto.LaptopDto;

import java.util.List;

public interface LaptopService {

    boolean registerLaptop(LaptopDto laptopDto);

    boolean deleteLaptop(int id);

    List<LaptopDto> getAllLaptop();
}
