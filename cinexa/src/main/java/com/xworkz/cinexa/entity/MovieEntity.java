package com.xworkz.cinexa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie_info")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "movie_language")
    @ElementCollection
    private List<String> movieLanguage;


    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL,orphanRemoval = true)
    private MovieImageEntity movieImageEntity;


    @Column(name = "movie_price")
    private int moviePrice;

}
