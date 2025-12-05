package com.xworkz.cinexa.service;

import com.xworkz.cinexa.dto.MovieDto;

import java.io.IOException;

public interface MovieService {

    boolean saveMovie(MovieDto movieDto) throws IOException;

}
