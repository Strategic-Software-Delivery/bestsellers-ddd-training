package com.sdd.cinemareservations;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieScreening {
    private ImmutableMap<String, Row> rows;
    private final int MAXIMUM_NUMBER_OF_ALLOWED_TICKETS = 8;

    public MovieScreening(Map<String, Row> rows) {
        this.rows = ImmutableMap.copyOf(rows);
    }

    public SeatsAllocated allocateSeats(AllocateSeats allocateSeats) {
        if (allocateSeats.partyRequested() > MAXIMUM_NUMBER_OF_ALLOWED_TICKETS) {
            return new TooManyTicketsRequested(allocateSeats.partyRequested(), new ArrayList<>());
        }
        for( Row row : rows.values()) {
            SeatsAllocated seatsAllocated = row.allocateSeats(allocateSeats);
            if (!(seatsAllocated instanceof NoPossibleAllocationsFound)) {
                reserveSeats(seatsAllocated.reservedSeats());
                return seatsAllocated;
            }
        }
        return new NoPossibleAllocationsFound(allocateSeats.partyRequested(), new ArrayList<>());
    }

    private void reserveSeats(List<Seat> updatedSeats) {
        Map<String, Row> newVersionOfRows = Maps.newHashMap(rows);

        for (Seat updatedSeat : updatedSeats) {
            Row formerRow = newVersionOfRows.get(updatedSeat.rowName());
            Row newVersionOfRow = formerRow.allocate(updatedSeat);
            newVersionOfRows.put(updatedSeat.rowName(), newVersionOfRow);
        }
        this.rows = ImmutableMap.copyOf(newVersionOfRows);
    }

}
