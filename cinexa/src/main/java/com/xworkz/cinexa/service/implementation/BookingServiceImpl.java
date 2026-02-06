package com.xworkz.cinexa.service.implementation;

import com.xworkz.cinexa.dto.BookingDto;
import com.xworkz.cinexa.entity.BookingEntity;
import com.xworkz.cinexa.entity.MovieEntity;
import com.xworkz.cinexa.repository.BookingRepository;
import com.xworkz.cinexa.repository.MovieRepository;
import com.xworkz.cinexa.service.interfaces.BookingService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final EmailService emailService;

    public BookingServiceImpl(BookingRepository bookingRepository, MovieRepository movieRepository, EmailService emailService) {
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.emailService = emailService;
    }

    @Override
    public boolean save(BookingDto dto) throws MessagingException {
        if (dto == null) {
            throw new RuntimeException("Booking data is empty");
        }

        Optional<MovieEntity> optionalMovie =
                movieRepository.findById(dto.getMovieId());

        if (optionalMovie.isEmpty()) {
            throw new RuntimeException("Movie not found with id: " + dto.getMovieId());
        }

        BookingEntity entity = new BookingEntity();
        entity.setBookingDate(dto.getBookingDate());
        log.info(dto.getUserEmail());
        entity.setSelectedSeats(dto.getSelectedSeats());
        entity.setMovie(optionalMovie.get());

        bookingRepository.save(entity);

//Async
        emailService.sendBookingEmail(dto,optionalMovie.get());

        return true;
    }
}
