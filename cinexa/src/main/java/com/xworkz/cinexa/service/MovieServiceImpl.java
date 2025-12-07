package com.xworkz.cinexa.service;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.entity.MovieEntity;
import com.xworkz.cinexa.entity.MovieImageEntity;
import com.xworkz.cinexa.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieServiceImpl  implements  MovieService{

    private final MovieRepository movieRepository;

    private final ImageService imageService;

    public MovieServiceImpl(MovieRepository movieRepository, ImageService imageService) {
        this.movieRepository = movieRepository;
        this.imageService = imageService;
    }


    @Override
    public boolean saveMovie(MovieDto movieDto) throws IOException {
        if (movieDto != null) {

            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setMovieName(movieDto.getMovieName());
            movieEntity.setMovieLanguage(movieDto.getMovieLanguage());
            movieEntity.setMoviePrice(movieDto.getMoviePrice());

            String movieUpdatedName=imageService.saveImageLocally(movieDto.getMovieName(), movieDto.getMovieImage());

            MovieImageEntity imageEntity = new MovieImageEntity();
            imageEntity.setImageName(movieUpdatedName);
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
