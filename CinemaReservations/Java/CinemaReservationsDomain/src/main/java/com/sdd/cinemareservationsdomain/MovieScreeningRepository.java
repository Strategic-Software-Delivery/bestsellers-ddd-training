package com.sdd.cinemareservationsdomain;

public interface MovieScreeningRepository {
    MovieScreening findMovieScreeningById(String screeningId) throws NoMovieScreeningFound;
}
