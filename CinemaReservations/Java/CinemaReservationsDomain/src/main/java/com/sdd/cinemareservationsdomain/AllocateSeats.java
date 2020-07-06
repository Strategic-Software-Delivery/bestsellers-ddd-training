package com.sdd.cinemareservationsdomain;

import lombok.Value;

@Value
public class AllocateSeats {

    String showId;
    int partyRequested;
}
