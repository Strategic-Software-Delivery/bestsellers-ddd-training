package com.sdd.cinemareservationsinfra.repository;

import com.sdd.cinemareservationsinfra.repository.model.JPAMovieScreening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringMovieScreeningRepository extends JpaRepository<JPAMovieScreening, String> {
}
