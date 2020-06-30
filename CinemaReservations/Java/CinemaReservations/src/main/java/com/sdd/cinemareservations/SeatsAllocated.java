package com.sdd.cinemareservations;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.List;

@Value
@NonFinal
public class SeatsAllocated {
    int partyRequested;
    List<Seat> reservedSeats;
}
