package com.xworkz.laptop.service;

import com.xworkz.laptop.dto.LaptopDto;
import com.xworkz.laptop.entity.LaptopEntity;
import com.xworkz.laptop.repository.LaptopReository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LaptopServiceImpl implements  LaptopService{
    private final LaptopReository laptopReository;

    public LaptopServiceImpl(LaptopReository laptopReository) {
        this.laptopReository = laptopReository;
    }

    @Override
    public boolean registerLaptop(LaptopDto laptopDto) {
        if(laptopDto!=null) {
            LaptopEntity laptopEntity=new LaptopEntity();
            BeanUtils.copyProperties(laptopDto,laptopEntity);
           LaptopEntity entity= laptopReository.save(laptopEntity);
           if(entity!=null){
               return true;
           }else{
               return false;
           }
        }
        return false;
    }

    @Override
    public boolean deleteLaptop(int id) {
        laptopReository.deleteById(id);
        return true;
    }

    @Override
    public List<LaptopDto> getAllLaptop() {
        List<LaptopEntity> laptopEntities=laptopReository.findAll();
        List<LaptopDto> laptopDtos=new ArrayList<>();
        if(!laptopEntities.isEmpty()){
            laptopEntities.forEach(laptop->{
                LaptopDto laptopDto=new LaptopDto();
                BeanUtils.copyProperties(laptop,laptopDto);
                laptopDtos.add(laptopDto);
            });
            return laptopDtos;
        }
        return Collections.emptyList();
    }
}
