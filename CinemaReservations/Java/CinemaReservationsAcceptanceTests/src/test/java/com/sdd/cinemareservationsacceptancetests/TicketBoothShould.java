package com.sdd.cinemareservationsacceptancetests;

import com.sdd.cinemareservations.*;
import com.sdd.cinemareservationsacceptancetests.StubMovieScreening.StubMovieScreeningRepository;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class TicketBoothShould {


    @Test
    public void reserve_one_seat_when_available() throws IOException, NoMovieScreeningFound {
        String showId = "1";
        int partyRequested = 1;

        MovieScreeningRepository repository =  new StubMovieScreeningRepository();
        TicketBooth ticketBooth = new TicketBooth(repository);

        SeatsAllocated seatsAllocated = ticketBooth.allocateSeats(new AllocateSeats(showId, partyRequested));

        assertThat(seatsAllocated.reservedSeats()).hasSize(1);
        assertThat(seatsAllocated.reservedSeats().get(0).toString()).isEqualTo("A3");
    }

    @Test
    public void return_SeatsNotAvailable_when_all_seats_are_unavailable() throws IOException, NoMovieScreeningFound {
        String showId = "5";
        int partyRequested = 1;

        MovieScreeningRepository repository =  new StubMovieScreeningRepository();
        TicketBooth ticketBooth = new TicketBooth(repository);

        SeatsAllocated seatsAllocated = ticketBooth.allocateSeats(new AllocateSeats(showId, partyRequested));

        assertThat(seatsAllocated).isInstanceOf(NoPossibleAllocationsFound.class);
    }

    @Test
    public void return_TooManyTicketsRequested_when_9_tickets_are_requested() throws IOException, NoMovieScreeningFound {
        String showId = "5";
        int partyRequested = 9;

        MovieScreeningRepository repository =  new StubMovieScreeningRepository();
        TicketBooth ticketBooth = new TicketBooth(repository);

        SeatsAllocated seatsAllocated = ticketBooth.allocateSeats(new AllocateSeats(showId, partyRequested));

        assertThat(seatsAllocated).isInstanceOf(TooManyTicketsRequested.class);
    }

    @Test
    public void reserve_three_adjacent_seats_when_available() throws IOException, NoMovieScreeningFound {
        String showId = "2";
        int partyRequested = 3;

        MovieScreeningRepository repository =  new StubMovieScreeningRepository();
        TicketBooth ticketBooth = new TicketBooth(repository);

        SeatsAllocated seatsAllocated = ticketBooth.allocateSeats(new AllocateSeats(showId, partyRequested));

        assertThat(seatsAllocated.reservedSeats()).hasSize(3);
        assertThat((seatsAllocated.seatNames())).containsExactly("A8", "A9", "A10");
    }

    @Test
    public void return_NoPossibleAdjacentSeatsFound_when_4_tickets_are_requested() throws IOException {
        String showId = "2";
        int partyRequested = 4;

        MovieScreeningRepository repository =  new StubMovieScreeningRepository();
        TicketBooth ticketBooth = new TicketBooth(repository);

        assertThat(true).isFalse();;
    }


}
