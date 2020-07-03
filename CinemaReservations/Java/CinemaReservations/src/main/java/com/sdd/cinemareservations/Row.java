package com.sdd.cinemareservations;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Row {
    private String name;
    private List<Seat> seats;

    public Row(String name, List<Seat> seats) {
        this.name = name;
        this.seats = seats;
    }

    public SeatsAllocated allocateSeats(AllocateSeats allocateSeats) {
        SeatAllocation allocation = new SeatAllocation(allocateSeats.partyRequested());

        for (Seat seat : this.seats()) {

            if (seat.isAvailable() && (allocation.allocatedSeats.isEmpty() || seat.isAdjacentWith(allocation.allocatedSeats)))
            {
                allocation.addSeat(seat);

                if(allocation.isFulfilled()) {
                    return new SeatsAllocated(allocateSeats.partyRequested(), allocation.allocatedSeats());
                }
            } else {
                allocation = new SeatAllocation(allocateSeats.partyRequested());
            }
        }
        return new NoPossibleAllocationsFound(allocateSeats.partyRequested(), new ArrayList<>());
    }

    public Row makeSeatsReserved(List<Seat> updatedSeats) {

        for (Seat newSeat : updatedSeats) {
            seats.set(seats.indexOf(newSeat), newSeat.reserveSeats());
        }
       return new Row(this.name, this.seats);
    }
}
