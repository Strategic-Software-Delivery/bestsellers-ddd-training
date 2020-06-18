package com.sdd.cinemareservationsacceptancetests.StubMovieScreening;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class SeatDto {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("SeatAvailability")
    private String seatAvailability;
}
