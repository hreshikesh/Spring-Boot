package com.example.GoldShop.service;

import ch.qos.logback.classic.Logger;
import com.example.GoldShop.dto.GoldDto;
import com.example.GoldShop.entity.GoldEntity;
import com.example.GoldShop.repository.GoldRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j

@Service
public class GoldServiceImpl  implements GoldService{

    private GoldRepository repository;

    public GoldServiceImpl(GoldRepository repository)
    {
        this.repository=repository;
    }

    @Override
    public String saveGold(GoldDto dto) {
        GoldEntity entity=new GoldEntity();
        BeanUtils.copyProperties(dto,entity);
        GoldEntity entity1=repository.save(entity);
        if(entity1!=null){
            return "saved";
        }else {
            return "not saved";
        }

    }

    @Override
    public GoldDto getGoldDetailsById(int id) {
        GoldEntity entity=repository.getReferenceById(id);
        GoldDto dto=new GoldDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    @Override
    public List<GoldDto> findByCompany(String company) {
        List<GoldEntity> goldEntities=repository.findByCompany(company);
        log.info(goldEntities.toString());
        List<GoldDto> goldDtos=new ArrayList<>();
        if(goldEntities!=null && !goldEntities.isEmpty()){
            goldEntities.forEach(goldEntity -> {
                GoldDto goldDto=new GoldDto();
                BeanUtils.copyProperties(goldEntity,goldDto);
                goldDtos.add(goldDto);
            });
            return goldDtos;
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public String findDealerNameByCompany(String companyName) {
        return repository.findDealerNameByCompany(companyName);
    }
}
