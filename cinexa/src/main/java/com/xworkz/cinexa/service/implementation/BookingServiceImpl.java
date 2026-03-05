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

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        entity.setPrice(dto.getPrice());

        bookingRepository.save(entity);
        emailService.sendBookingEmail(dto,optionalMovie.get());

        return true;
    }

    @Override
    public List<String> getAllBookedSeat(LocalDate date, int movieId) {
        log.info(String.valueOf(date)+String.valueOf(movieId));
       List<BookingEntity> bookingEntityList= bookingRepository.findAll();

       if(!bookingEntityList.isEmpty()){
          return bookingEntityList.stream()
                  .filter(bookingEntity -> bookingEntity.getBookingDate().isEqual(date) && bookingEntity.getMovie().getId()==movieId)
                   .flatMap(bookingEntity -> bookingEntity.getSelectedSeats().stream()).toList();
       }
        return List.of();
    }
}
