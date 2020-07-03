package com.sdd.cinemareservations;

import java.util.ArrayList;
import java.util.List;

public class NoPossibleAdjacentSeatsFound extends SeatsAllocated {
    public NoPossibleAdjacentSeatsFound(int partyRequested, List<Seat> reservedSeats) {
        super(partyRequested, reservedSeats);
    }
}
