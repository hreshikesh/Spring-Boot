package com.xworkz.cinexa.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class BookingDto {
    private int movieId;
    private LocalDate bookingDate;
    private List<String> selectedSeats;
}
