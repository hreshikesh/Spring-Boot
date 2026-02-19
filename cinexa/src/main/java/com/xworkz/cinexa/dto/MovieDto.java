package com.xworkz.cinexa.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto{


    private int id;


    @NotNull(message = "Movie name cannot be empty")
    @Size(min = 3,max = 20,message = "Movie name  length should be about 3 and 20")
    private String movieName;

    @NotNull(message = "Movie Langauage Should not be empty")
    private List<String> movieLanguage;


    @NotNull(message = "Movie image should be uploaded")
    private MultipartFile movieImage;

    @NotNull(message = "Movie Price cannot empty")
    @Min(value = 50,message = "Minimum movie ticket price is 50")
    @Max(value = 300,message = "Movie max price is 300")
    private int moviePrice;

    private String imageName;
}
