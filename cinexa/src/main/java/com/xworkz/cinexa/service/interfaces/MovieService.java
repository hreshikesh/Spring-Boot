package com.xworkz.cinexa.service.interfaces;

import com.xworkz.cinexa.dto.MovieDto;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface MovieService {

    boolean saveMovie(MovieDto movieDto) throws IOException, MessagingException;

    long getMovieCount();

    Page<MovieDto> fetchAllMovie(int page,int size);

    MovieDto findMovieById(int id);


}
