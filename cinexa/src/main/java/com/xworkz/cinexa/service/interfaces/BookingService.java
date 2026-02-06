package com.xworkz.cinexa.service.interfaces;

import com.xworkz.cinexa.dto.BookingDto;
import jakarta.mail.MessagingException;

public interface BookingService {
    boolean save(BookingDto dto) throws MessagingException;
}
