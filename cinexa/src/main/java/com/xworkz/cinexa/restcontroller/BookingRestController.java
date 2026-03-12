package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.BookingDto;
import com.xworkz.cinexa.service.interfaces.BookingService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/booking")
@Slf4j
public class BookingRestController {
    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/createBooking")
    public ResponseEntity<String> movieSeatBooking(@RequestBody @Valid BookingDto bookingDto) throws MessagingException {
        log.info(String.valueOf(bookingDto.getPrice()));
        return bookingService.save(bookingDto) ? ResponseEntity.ok().body("Seats Successfully Booked") :
                ResponseEntity.badRequest().body("Error in Booking");
    }


    @GetMapping("/getAllBookedSeats/{date}/{movieId}")
    public ResponseEntity<List<String>> getAllBookedSeatOfMovie(@PathVariable LocalDate date, @PathVariable int movieId){

         List<String> seats=bookingService.getAllBookedSeat(date,movieId);
         if(!seats.isEmpty()){
             return ResponseEntity.ok().body(seats);
         }
            throw new RuntimeException("Something Went wrong");
    }


}
