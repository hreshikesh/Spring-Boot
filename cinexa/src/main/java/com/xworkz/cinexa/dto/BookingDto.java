package com.xworkz.cinexa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class BookingDto implements Serializable {
    private int movieId;
    @NotNull(message = "UserEmail Cannot be empty")
    @Email
    private String userEmail;
    @NotNull(message = "Error Saving Price")
    private int price;
    @NotNull(message = "Please Select a date")
    private LocalDate bookingDate;
    @NotNull(message="Select Seats")
    private List<String> selectedSeats;
}
