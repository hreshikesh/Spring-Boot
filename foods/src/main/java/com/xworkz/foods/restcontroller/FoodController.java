package com.xworkz.foods.restcontroller;

import com.xworkz.foods.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:1234")
@RestController
@Slf4j
@RequestMapping("/api/user")
public class FoodController {

    @PostMapping("/save")
    public void saveDetails(@RequestBody UserDto userDto){
        log.info("save method");
        log.info(userDto.getUserName());
        log.info(userDto.getUserEmail());
        log.info(userDto.getUserPassword());
        log.info(userDto.getUserGender());
        log.info(userDto.getUserSkills());
        log.info(userDto.getUserCity());
        log.info(String.valueOf(userDto.getUserAge()));
        log.info(userDto.getUserCountry());
        log.info(String.valueOf(userDto.getUserPhone()));
    }
}
