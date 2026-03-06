package com.xworkz.cinexa.repository;

import com.xworkz.cinexa.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

    @Query("SELECT b FROM BookingEntity b WHERE b.bookingDate = :date AND b.movie.id = :movieId")
    List<BookingEntity> findByDateAndMovieId(LocalDate date, int movieId);
}
