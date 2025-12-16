package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.service.interfaces.MovieService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/movie")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<String> saveMovieDetails(@ModelAttribute @Valid MovieDto movieDto) throws IOException, MessagingException {
        return movieService.saveMovie(movieDto) ? ResponseEntity.ok("Movie Details Successfully Saved") :
        ResponseEntity.badRequest().body("Error in saving Deatils");
    }

    @GetMapping("/countMovies")
    public ResponseEntity<Long> getMovieCount(){
        return ResponseEntity.ok(movieService.getMovieCount());
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<Page<MovieDto>> getAllMovies(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size){
        return ResponseEntity.ok(movieService.fetchAllMovie(page,size));
    }
}
