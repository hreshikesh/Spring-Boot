package com.xworkz.cinexa.service;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.entity.MovieEntity;
import com.xworkz.cinexa.entity.MovieImageEntity;
import com.xworkz.cinexa.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl  implements  MovieService{

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public boolean saveMovie(MovieDto movieDto) {
        if (movieDto != null) {

            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setMovieName(movieDto.getMovieName());
            movieEntity.setMovieLanguage(movieDto.getMovieLanguage());
            movieEntity.setMovieBudget(movieDto.getMovieBudget());
            movieEntity.setMoviePrice(movieDto.getMoviePrice());

            MovieImageEntity imageEntity = new MovieImageEntity();
            imageEntity.setImageName(movieDto.getMovieImage().getName());
            imageEntity.setImageOriginalName(movieDto.getMovieImage().getOriginalFilename());
            imageEntity.setImagePath("ImagePath");
            imageEntity.setSize(movieDto.getMovieImage().getSize());


            imageEntity.setMovie(movieEntity);
            movieEntity.setMovieImageEntity(imageEntity);

            movieRepository.save(movieEntity);

            return true;
        }

        throw new RuntimeException("Error in saving movie details");
    }
}
