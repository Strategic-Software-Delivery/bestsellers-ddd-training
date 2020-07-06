package com.sdd.cinemareservationsinfra.repository;

import com.sdd.cinemareservationsdomain.MovieScreening;
import com.sdd.cinemareservationsdomain.MovieScreeningRepository;
import com.sdd.cinemareservationsdomain.NoMovieScreeningFound;
import com.sdd.cinemareservationsinfra.repository.model.JPAMovieScreening;

import java.util.Optional;

public class JPAMovieScreeningRepository implements MovieScreeningRepository {

    private SpringMovieScreeningRepository springMovieScreeningRepository;

    public JPAMovieScreeningRepository(SpringMovieScreeningRepository springMovieScreeningRepository) {
        this.springMovieScreeningRepository = springMovieScreeningRepository;
    }

    @Override
    public MovieScreening findMovieScreeningById(String screeningId) throws NoMovieScreeningFound {
        Optional<JPAMovieScreening> jpaMovieScreening = springMovieScreeningRepository.findById(screeningId);
        if (jpaMovieScreening.isPresent()) {
            return fromJPAMovieScreening(jpaMovieScreening.get());
        }
        throw new NoMovieScreeningFound("No MovieScreening found with Id " + screeningId);
    }

    @Override
    public MovieScreening finaliseAllocation(MovieScreening movieScreening) {
        //TODO implement me
        return movieScreening;
    }

    private MovieScreening fromJPAMovieScreening(JPAMovieScreening jpaMovieScreening) {
        //TODO Implement me
        return null;
    }

}
