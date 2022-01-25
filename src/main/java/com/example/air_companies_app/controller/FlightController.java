package com.example.air_companies_app.controller;

import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import com.example.air_companies_app.dto.request.FlightRequestDto;
import com.example.air_companies_app.dto.response.FlightResponseDto;
import com.example.air_companies_app.model.Flight;
import com.example.air_companies_app.service.FlightService;
import com.example.air_companies_app.service.mapper.FlightMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    public FlightController(FlightService flightService, FlightMapper flightMapper) {
        this.flightService = flightService;
        this.flightMapper = flightMapper;
    }

    @PostMapping
    public FlightResponseDto add(FlightRequestDto dto) {
        return flightMapper.parseToDto(flightService
                .saveOrUpdate(flightMapper.parseToModel(dto)));
    }

    @PatchMapping("/{id}")
    public FlightResponseDto updateStatus(@PathVariable(value = "id") Long id,
                                          @RequestBody String flightStatus) {
        Flight flight = flightService.getById(id);
        flight.setFlightStatus(Flight.FlightStatus
                .valueOf(flightStatus.toUpperCase(Locale.ROOT)));
        return flightMapper.parseToDto(flightService.saveOrUpdate(flight));
    }

    @GetMapping("/delayed")                     //Optional
    public List<FlightResponseDto> getDelayedFlight() {
        return flightService.getAll().stream()
                .filter(f -> f.getFlightStatus() == Flight.FlightStatus.COMPLETED
                        && Duration.between(f.getStartedAt(), f.getEndedAt())
                        .compareTo(f.getEstimatedFlightTime()) > 0)
                .map(flightMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
