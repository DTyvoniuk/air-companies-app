package com.example.air_companies_app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightResponseDto {
    private Long id;
    private String flightStatus;
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
