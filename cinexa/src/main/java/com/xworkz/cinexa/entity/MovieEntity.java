package com.xworkz.cinexa.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
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

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<BookingEntity> bookingEntity;


    @Column(name = "movie_price")
    private int moviePrice;

}
