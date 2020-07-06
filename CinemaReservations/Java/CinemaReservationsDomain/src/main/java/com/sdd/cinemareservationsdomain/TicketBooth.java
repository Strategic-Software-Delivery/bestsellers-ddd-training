package com.sdd.cinemareservationsdomain;

public class TicketBooth {
    private MovieScreeningRepository movieScreeningRepository;

    public TicketBooth(MovieScreeningRepository repo)
    {
        this.movieScreeningRepository = repo;
    }

    public SeatsAllocated allocateSeats(AllocateSeats allocateSeats) throws NoMovieScreeningFound {
        MovieScreening movieScreening = movieScreeningRepository.findMovieScreeningById(allocateSeats.showId());

        SeatsAllocated seatsAllocated =  movieScreening.allocateSeats(allocateSeats);
        if(!(seatsAllocated instanceof NoPossibleAdjacentSeatsFound || seatsAllocated instanceof NoPossibleAllocationsFound)) {
            movieScreeningRepository.finaliseAllocation(movieScreening);
        }
        return seatsAllocated;
    }
}
