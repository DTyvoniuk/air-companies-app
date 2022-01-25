package com.example.air_companies_app.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import com.example.air_companies_app.model.Flight;
import com.example.air_companies_app.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/air-companies")
public class AirCompanyController {
    private final FlightService flightService;

    public AirCompanyController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public Flight getFlightByid(@PathVariable(value = "id") Long id) {
        return flightService.getById(id);
    }

    @PatchMapping("/{name}")
    public List<Flight> getFlightByStatusAndCompany(@PathVariable(value = "name") String name,
                                                    @RequestParam(value = "status") String status) {
        return flightService.getByName(name).stream()
                .filter(f -> f.getFlightStatus()
                        .equals(Flight.FlightStatus.valueOf(status.toUpperCase(Locale.ROOT))))
                .collect(Collectors.toList());
    }

    @GetMapping("/active")
    public List<Flight> getAvailableAndActiveFlights() {
        return flightService.getAllByFlightStatusAndStartedAtAfter(
                Flight.FlightStatus.ACTIVE, LocalDateTime.now().minusDays(1));
    }
}
