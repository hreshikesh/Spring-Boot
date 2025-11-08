package com.xworkz.laptop.service;

import com.xworkz.laptop.dto.LaptopDto;
import com.xworkz.laptop.entity.LaptopEntity;
import com.xworkz.laptop.repository.LaptopReository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Slf4j
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
       Optional<LaptopEntity> laptopEntity =laptopReository.findById(id);
       if(laptopEntity.isPresent()){
           laptopReository.deleteById(id);
           return true;
       }else{
           return false;
       }

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

    @Override
    public LaptopDto findById(int id) {
        Optional<LaptopEntity> laptopEntity= laptopReository.findById(id);
        if(laptopEntity!=null &&laptopEntity.isPresent()){
            com.xworkz.laptop.dto.LaptopDto laptopDto=new LaptopDto();
            BeanUtils.copyProperties(laptopEntity.get(),laptopDto);
            log.info(laptopDto.toString());
            return laptopDto;
        }else {
            return null;
        }
    }

    @Override
    public boolean updateLaptop(LaptopDto laptopDto) {
      Optional<LaptopEntity> laptopEntity=  laptopReository.findById(laptopDto.getId());
        if (laptopEntity.isPresent()) {
            LaptopEntity laptop = laptopEntity.get();
            laptop.setLaptopName(laptopDto.getLaptopName());
            laptop.setLaptopBrand(laptopDto.getLaptopBrand());
            laptop.setLaptopPrice(laptopDto.getLaptopPrice());
            laptop.setOwnerName(laptopDto.getOwnerName());

            laptopReository.save(laptop);
            return true;
        } else {
            return false;
        }
    }
}
