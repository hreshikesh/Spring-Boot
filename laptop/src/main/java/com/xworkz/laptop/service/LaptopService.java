package com.xworkz.laptop.service;

import com.xworkz.laptop.dto.LaptopDto;

import java.util.List;
import java.util.Optional;

public interface LaptopService {

    boolean registerLaptop(LaptopDto laptopDto);

    boolean deleteLaptop(int id);

    List<LaptopDto> getAllLaptop();

     LaptopDto findById(int id);

     boolean updateLaptop(LaptopDto laptopDto);
}
