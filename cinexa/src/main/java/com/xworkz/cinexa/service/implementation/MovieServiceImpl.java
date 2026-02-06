package com.xworkz.cinexa.service.implementation;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.entity.MovieEntity;
import com.xworkz.cinexa.entity.MovieImageEntity;
import com.xworkz.cinexa.repository.MovieRepository;
import com.xworkz.cinexa.service.interfaces.MovieService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@Slf4j
public class MovieServiceImpl  implements MovieService {

    private final MovieRepository movieRepository;

    private final ImageService imageService;

    private final EmailService emailService;

    public MovieServiceImpl(MovieRepository movieRepository, ImageService imageService, EmailService emailService) {
        this.movieRepository = movieRepository;
        this.imageService = imageService;
        this.emailService = emailService;
    }


    @Override
    public boolean saveMovie(MovieDto movieDto) throws IOException, MessagingException {
        if (movieDto != null) {

            MovieEntity movieEntity = new MovieEntity();
            movieEntity.setMovieName(movieDto.getMovieName());
            movieEntity.setMovieLanguage(movieDto.getMovieLanguage());
            movieEntity.setMoviePrice(movieDto.getMoviePrice());

            String movieUpdatedName=imageService.saveImageLocally(movieDto.getMovieName(), movieDto.getMovieImage());

            MovieImageEntity imageEntity = new MovieImageEntity();
            imageEntity.setImageName(movieUpdatedName);
            imageEntity.setImageOriginalName(movieDto.getMovieImage().getOriginalFilename());
            imageEntity.setImagePath("D:\\cinexa"+movieUpdatedName);
            imageEntity.setSize(movieDto.getMovieImage().getSize());



            imageEntity.setMovie(movieEntity);
            movieEntity.setMovieImageEntity(imageEntity);

            movieRepository.save(movieEntity);

            emailService.sendSaveMovieEmail(movieEntity);

            return true;
        }

        throw new RuntimeException("Error in saving movie details");
    }

    @Override
    public long getMovieCount() {
        return movieRepository.count();
    }


    private MovieDto convertToDto(MovieEntity movieEntity){
        MovieDto movieDto=new MovieDto();
        movieDto.setId(movieEntity.getId());
        movieDto.setMovieName(movieEntity.getMovieName());
        movieDto.setMovieLanguage(movieEntity.getMovieLanguage());
        movieDto.setImageName(movieEntity.getMovieImageEntity().getImageName());
        movieDto.setMoviePrice(movieEntity.getMoviePrice());
        return movieDto;
    }

    @Override
    public Page<MovieDto> fetchAllMovie(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<MovieEntity> movieEntityPage = movieRepository.findAll(pageable);

        log.info("Movies fetched: {}", movieEntityPage.getNumberOfElements());
           return movieEntityPage.map(movieEntity -> convertToDto(movieEntity));

    }

    @Override
    public MovieDto findMovieById(int id) {
        Optional<MovieEntity> optionalMovieEntity=movieRepository.findById(id);
        if(optionalMovieEntity.isPresent()){
            MovieEntity movieEntity=optionalMovieEntity.get();

            return convertToDto(movieEntity);
        }else{
            throw new RuntimeException("Movie Details Not Found");
        }
    }
}
