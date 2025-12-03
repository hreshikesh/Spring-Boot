package com.example.GoldShop.restcontroller;

import com.example.GoldShop.dto.GoldDto;
import com.example.GoldShop.service.GoldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping(value = "id/{id}",produces = "application/json")
    public ResponseEntity<GoldDto> getGoldDetails(@PathVariable int id){
        GoldDto dto=service.getGoldDetailsById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("company/{company}")
    public ResponseEntity<List<GoldDto>> findShopByCompany(@PathVariable String company){
        log.info(company);
            List<GoldDto> goldDtos=service.findByCompany(company);
            if(goldDtos!=null && !goldDtos.isEmpty()){
                return ResponseEntity.ok(goldDtos);
            }else{
                return  ResponseEntity.noContent().build();
            }
    }

    @GetMapping("companyName/{companyName}")
    public String findDealerByCompanyName(@PathVariable String companyName){
        String name=service.findDealerNameByCompany(companyName);
        if(name!=null){
            return name;
        }else {
            return "Name not found";
        }
    }

}
