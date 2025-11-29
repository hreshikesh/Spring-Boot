package com.xworkz.cinexa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_image_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="movie_id",referencedColumnName = "id")
    private MovieEntity movie;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "image_original_Name")
    private String  imageOriginalName;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image_size")
    private long size;
}
