package com.sdd.cinemareservations;

import java.util.ArrayList;
import java.util.Map;

public class MovieScreening {
    private Map<String, Row> rows;
    private final int MAXIMUM_NUMBER_OF_ALLOWED_TICKETS = 8;

    public MovieScreening(Map<String, Row> rows) {
        this.rows = rows;
    }

    public SeatsAllocated allocateSeats(AllocateSeats allocateSeats) {
        if (allocateSeats.partyRequested() > MAXIMUM_NUMBER_OF_ALLOWED_TICKETS) {
            return new TooManyTicketsRequested(allocateSeats.partyRequested(), new ArrayList<>());
        }
        int numberOfSeatsAvailable = 0;
        for( Row row : rows.values()) {
            SeatsAllocated seatsAllocated = row.allocateSeats(allocateSeats);
            if (!(seatsAllocated instanceof NoPossibleAllocationsFound)) {
                Row updatedRow = row.makeSeatsReserved(seatsAllocated.reservedSeats());
                rows.put(updatedRow.name(), updatedRow);
                return seatsAllocated;
            }
            numberOfSeatsAvailable = numberOfSeatsAvailable + row.returnNumberOfSeatsAvailable();
        }
        if(numberOfSeatsAvailable >= allocateSeats.partyRequested()) {
            return new NoPossibleAdjacentSeatsFound(allocateSeats.partyRequested(), new ArrayList<>());
        }
        return new NoPossibleAllocationsFound(allocateSeats.partyRequested(), new ArrayList<>());
    }

}
