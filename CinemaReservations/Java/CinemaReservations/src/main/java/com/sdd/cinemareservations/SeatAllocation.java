package com.sdd.cinemareservations;

import lombok.Value;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class SeatAllocation {

    public int partyRequested;
    public List<Seat> allocatedSeats = new ArrayList<>();

    public boolean isFulfilled() {
      return allocatedSeats.size() == partyRequested;
    }

    public SeatAllocation(int partyRequested)
    {
        this.partyRequested = partyRequested;
    }
    public void addSeat(Seat seat)
    {
        allocatedSeats.add(seat);
    }
}
