package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.SeatDto;
import com.xworkz.cinexa.service.interfaces.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequestMapping("/api/seat")
public class SeatRestController {
    private final SeatService seatService;

    public SeatRestController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/getSeat")
    public ResponseEntity<List<SeatDto>> getAllSeat(){
        return ResponseEntity.ok().body(seatService.getAllSeat());
    }
}
