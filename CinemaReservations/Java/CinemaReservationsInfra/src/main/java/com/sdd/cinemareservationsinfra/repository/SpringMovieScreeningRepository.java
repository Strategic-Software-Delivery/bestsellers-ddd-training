package com.sdd.cinemareservationsinfra.repository;

import com.sdd.cinemareservationsdomain.MovieScreening;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO Entity needs it's own JPA Model
public interface SpringMovieScreeningRepository extends JpaRepository<MovieScreening, String> {
}
