package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.BookingDto;
import com.xworkz.cinexa.service.interfaces.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
public class BookingRestController {
    private final BookingService bookingService;

    public BookingRestController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/createBooking")
    public ResponseEntity<String> movieSeatBooking(@RequestBody @Valid BookingDto bookingDto) {
        return bookingService.save(bookingDto) ? ResponseEntity.ok().body("Seats Successfully Booked") :
                ResponseEntity.badRequest().body("Error in Booking");
    }
}
