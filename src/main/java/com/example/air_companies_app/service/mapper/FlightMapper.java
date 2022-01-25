package com.example.air_companies_app.service.mapper;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import com.example.air_companies_app.dto.request.FlightRequestDto;
import com.example.air_companies_app.dto.response.FlightResponseDto;
import com.example.air_companies_app.model.Flight;
import com.example.air_companies_app.service.AirCompanyService;
import com.example.air_companies_app.service.AirplaneService;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;

    public FlightMapper(AirCompanyService airCompanyService,
                        AirplaneService airplaneService) {
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
    }

    public FlightResponseDto parseToDto(Flight flight) {
        FlightResponseDto dto = new FlightResponseDto();
        dto.setId(flight.getId());
        dto.setFlightStatus(flight.getFlightStatus().name());
        dto.setAirCompany_id(flight.getAirCompany().getId());
        dto.setAirplane_id(flight.getAirplane().getId());
        dto.setDepartureCountry(flight.getDepartureCountry());
        dto.setDestinationCountry(flight.getDestinationCountry());
        dto.setDistance(flight.getDistance());
        dto.setEstimatedFlightTime(flight.getEstimatedFlightTime().toHours());
        dto.setStartedAt(flight.getStartedAt().format(DateTimeFormatter.ISO_DATE_TIME));
        dto.setEndedAt(flight.getEndedAt().format(DateTimeFormatter.ISO_DATE_TIME));
        dto.setDelayStartedAt(flight.getDelayStartedAt().format(DateTimeFormatter.ISO_TIME));
        dto.setCreatedAt(flight.getCreatedAt().format(DateTimeFormatter.ISO_DATE));
        return dto;
    }

    public Flight parseToModel(FlightRequestDto dto) {
        Flight flight = new Flight();
        if (dto.getFlightStatus() != null) {
            flight.setFlightStatus(dto.getFlightStatus());
        } else {
            flight.setFlightStatus(Flight.FlightStatus.PENDING);
        }
        flight.setAirCompany(airCompanyService.getById(dto.getAirCompany_id()));
        flight.setAirplane(airplaneService.getById(dto.getAirplane_id()));
        flight.setDepartureCountry(dto.getDepartureCountry());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setDistance(dto.getDistance());
        flight.setEstimatedFlightTime(Duration.of(dto.getEstimatedFlightTime(),
                ChronoUnit.HOURS));
        flight.setStartedAt(LocalDateTime.parse(dto.getStartedAt(),
                DateTimeFormatter.ISO_DATE_TIME));
        flight.setEndedAt(LocalDateTime.parse(dto.getEndedAt(),
                DateTimeFormatter.ISO_DATE_TIME));
        flight.setDelayStartedAt(LocalTime.parse(dto.getDelayStartedAt(),
                DateTimeFormatter.ISO_TIME));
        flight.setCreatedAt(LocalDate.parse(dto.getCreatedAt(),
                DateTimeFormatter.ISO_DATE));
        return flight;
    }
}
