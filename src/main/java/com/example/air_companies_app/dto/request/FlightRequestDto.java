package com.example.air_companies_app.dto.request;

import com.example.air_companies_app.model.Flight;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightRequestDto {
    private Flight.FlightStatus flightStatus;
    private Long airCompany_id;
    private Long airplane_id;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private Long estimatedFlightTime;
    private String startedAt;
    private String endedAt;
    private String delayStartedAt;
    private String createdAt;
}
