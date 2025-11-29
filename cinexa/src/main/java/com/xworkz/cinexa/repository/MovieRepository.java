package com.xworkz.cinexa.repository;

import com.xworkz.cinexa.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<MovieEntity,Integer> {
}
