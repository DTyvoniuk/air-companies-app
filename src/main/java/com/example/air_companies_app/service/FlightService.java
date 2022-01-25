package com.example.air_companies_app.service;

import java.time.LocalDateTime;
import java.util.List;
import com.example.air_companies_app.model.Flight;

public interface FlightService {
    Flight getById(Long id);

    List<Flight> getByName(String name);

    Flight saveOrUpdate(Flight flight);

    List<Flight> getAllByFlightStatusAndStartedAtAfter(Flight.FlightStatus flightStatus,
                                                       LocalDateTime startedAt);
    List<Flight> getAll();
}
