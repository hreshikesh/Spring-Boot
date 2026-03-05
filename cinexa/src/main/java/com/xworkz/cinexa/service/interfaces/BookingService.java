package com.xworkz.cinexa.service.interfaces;

import com.xworkz.cinexa.dto.BookingDto;
import jakarta.mail.MessagingException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface BookingService {
    boolean save(BookingDto dto) throws MessagingException;

    List<String> getAllBookedSeat(LocalDate date, int movieId);
}
