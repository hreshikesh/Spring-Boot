package com.example.GoldShop.service;

import com.example.GoldShop.dto.GoldDto;
import com.example.GoldShop.entity.GoldEntity;
import com.example.GoldShop.repository.GoldRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
}
