package com.xworkz.cinexa.service.implementation;

import com.xworkz.cinexa.dto.MovieLangauageDto;
import com.xworkz.cinexa.repository.MovieLanguageRepository;
import com.xworkz.cinexa.service.interfaces.MovieLangauagesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieLangaugeServiceImpl implements MovieLangauagesService {

    private final MovieLanguageRepository movieLanguageRepository;

    public MovieLangaugeServiceImpl(MovieLanguageRepository movieLanguageRepository) {
        this.movieLanguageRepository = movieLanguageRepository;
    }

    @Override
    public List<MovieLangauageDto> getAllMovieLangauage() {
        List<MovieLangauageDto> movieLangauageDtos=new ArrayList<>();
        movieLanguageRepository.findAll().forEach(
                data->{
                        MovieLangauageDto movieLangauageDto=new MovieLangauageDto();
                    BeanUtils.copyProperties(data,movieLangauageDto);
                    movieLangauageDtos.add(movieLangauageDto);
                }
        );
        return movieLangauageDtos;
    }
}
