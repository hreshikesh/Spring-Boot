package com.example.GoldShop.restcontroller;

import com.example.GoldShop.dto.GoldDto;
import com.example.GoldShop.service.GoldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/GoldShop/")
public class GoldRestController {

    private static final Logger log = LoggerFactory.getLogger(GoldRestController.class);

    private final GoldService service;

    public GoldRestController(GoldService service) {
        this.service = service;
    }


    @PostMapping("addGolds")
    public String addGold(@RequestBody GoldDto dto){
        String result=service.saveGold(dto);
        return result;
    }

    @GetMapping("{id}")
    public String getGoldDetails(@PathVariable int id){
        GoldDto dto=service.getGoldDetailsById(id);
        return dto.toString();
    }


}
