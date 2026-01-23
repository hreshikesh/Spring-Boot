package com.xworkz.cinexa.restcontroller;

import com.xworkz.cinexa.dto.MovieDto;
import com.xworkz.cinexa.service.implementation.ImageService;
import com.xworkz.cinexa.service.interfaces.MovieService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/movie")
public class MovieRestController {

    private static final Logger log = LoggerFactory.getLogger(MovieRestController.class);
    private final MovieService movieService;

    private final ImageService imageService;

    public MovieRestController(MovieService movieService, ImageService imageService) {
        this.movieService = movieService;
        this.imageService = imageService;
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<String> saveMovieDetails(@ModelAttribute @Valid MovieDto movieDto) throws IOException, MessagingException {
        return movieService.saveMovie(movieDto) ? ResponseEntity.ok("Movie Details Successfully Saved") :
                ResponseEntity.badRequest().body("Error in saving Deatils");
    }

    @GetMapping("/countMovies")
    public ResponseEntity<Long> getMovieCount() {
        return ResponseEntity.ok(movieService.getMovieCount());
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<Page<MovieDto>> getAllMovies(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(movieService.fetchAllMovie(page, size));
    }

    @GetMapping("/movieImage/{url}")
    public ResponseEntity<byte[]> displayMovieImage(@PathVariable String url) throws IOException {
        log.info(url);
        return imageService.previewMovieImage(url);
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable int id){
        return ResponseEntity.ok().body(movieService.findMovieById(id));
    }
}
