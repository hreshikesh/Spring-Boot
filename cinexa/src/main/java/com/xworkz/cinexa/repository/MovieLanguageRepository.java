package com.xworkz.cinexa.repository;

import com.xworkz.cinexa.entity.MovieLangauageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieLanguageRepository extends JpaRepository<MovieLangauageEntity,Integer> {
}
