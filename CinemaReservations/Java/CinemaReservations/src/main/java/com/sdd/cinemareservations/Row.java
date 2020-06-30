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

            if (seat.isAvailable())
            {
                allocation.addSeat(seat);

                if(allocation.isFulfilled()) {
                    return new SeatsAllocated(allocateSeats.partyRequested(), allocation.allocatedSeats());
                }
            }
        }
        return new NoPossibleAllocationsFound(allocateSeats.partyRequested(), new ArrayList<>());
    }

    public Row allocate(Seat seat) {
        List<Seat> newVersionOfSeats = new ArrayList<>();

        seats.forEach(currentSeat -> {
            if (currentSeat.sameSeatLocation(seat)) {
                newVersionOfSeats.add(new Seat(seat.rowName(), seat.number(),
                        SeatAvailability.Reserved));
            } else {
                newVersionOfSeats.add(currentSeat);
            }
        });

        return new Row(seat.rowName(), newVersionOfSeats);
    }
}
