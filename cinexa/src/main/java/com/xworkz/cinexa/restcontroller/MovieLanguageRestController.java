package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.MovieLangauageDto;
import com.xworkz.cinexa.service.interfaces.MovieLangauagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieLanguageRestController {

    private final MovieLangauagesService movieLangauagesService;

    public MovieLanguageRestController(MovieLangauagesService movieLangauagesService) {
        this.movieLangauagesService = movieLangauagesService;
    }

    @GetMapping("/getAllMoviesLanguages")
    public ResponseEntity<List<MovieLangauageDto>> getAllMovieDetails(){
       List<MovieLangauageDto> movieLangauageDtoList= movieLangauagesService.getAllMovieLangauage();
       if(movieLangauageDtoList!=null && !movieLangauageDtoList.isEmpty()){
           return ResponseEntity.ok(movieLangauageDtoList);
       }else{
           throw  new RuntimeException("No Languages found ....");
       }
    }
}
