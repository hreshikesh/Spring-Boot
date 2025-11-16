package com.xworkz.laptop.restcontroller;

import com.xworkz.laptop.dto.LaptopDto;
import com.xworkz.laptop.service.LaptopService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
@RequestMapping("/api/Laptop/")
public class LaptopRestController {

    private final LaptopService laptopService;

    public LaptopRestController( LaptopService service) {
        this.laptopService = service;
    }

    @PostMapping("registerLaptop")
    public ResponseEntity<?> saveLaptopDetails(@Valid  @RequestBody LaptopDto dto, BindingResult result) {
        if(result.hasErrors()){

            List<String> serverErrors=result.getFieldErrors().stream().map(error->error.getDefaultMessage()).toList();

            return  ResponseEntity.badRequest().body(serverErrors);
        }
            boolean isSaved = laptopService.registerLaptop(dto);
            if (isSaved) {
                return ResponseEntity.ok("Register Successfully");
            } else {
                return ResponseEntity.badRequest().body("Registration Failed");
            }
    }

    @DeleteMapping("deleteLaptop/{id}")
    public ResponseEntity<String> deleteLaptopById(@PathVariable  int id){
        boolean isDeleted=laptopService.deleteLaptop(id);
        if(isDeleted){
            return ResponseEntity.ok("Deleted Successfully");
        }else{
            return  ResponseEntity.badRequest().body("Delete not successfull");
        }
    }

    @GetMapping("getAllLaptop")
    public ResponseEntity<List<LaptopDto>> fetchAllLaptopDetails(){
        List<LaptopDto> laptopDtos=laptopService.getAllLaptop();
        if(!laptopDtos.isEmpty()){
            return ResponseEntity.ok(laptopDtos);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<LaptopDto> findById(@PathVariable int id){
        LaptopDto laptopDto=laptopService.findById(id);
        if(laptopDto!=null){
            return ResponseEntity.ok(laptopDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("updateLaptop")
    public ResponseEntity<LaptopDto> updateLaptopDetails(@RequestBody LaptopDto laptopDto){
        log.info(laptopDto.toString());
        boolean isUpdated=laptopService.updateLaptop(laptopDto);
        if(isUpdated){
            return ResponseEntity.ok(laptopDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
