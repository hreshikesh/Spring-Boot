package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieSaveRestController {

    private final MovieService movieService;

    public MovieSaveRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<String> saveMovieDetails(@ModelAttribute @Valid MovieDto movieDto){
        return movieService.saveMovie(movieDto) ? ResponseEntity.ok("Movie Details Successfully Saved") :
        ResponseEntity.badRequest().body("Error in saving Deatils");
    }
}
