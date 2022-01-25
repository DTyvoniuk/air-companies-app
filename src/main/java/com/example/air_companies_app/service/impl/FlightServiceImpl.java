package com.example.air_companies_app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.example.air_companies_app.model.Flight;
import com.example.air_companies_app.repository.FlightRepository;
import com.example.air_companies_app.service.FlightService;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight getById(Long id) {
        return flightRepository.getById(id);
    }

    @Override
    public List<Flight> getByName(String name) {
        return flightRepository.getAllByAirCompany_Name(name);
    }

    @Override
    public Flight saveOrUpdate(Flight flight) {
        if (flight.getAirplane() != null) {
            flight.getAirplane()
                    .setNumberOfFlight(flight.getAirplane().getNumberOfFlight() + 1);
        }
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllByFlightStatusAndStartedAtAfter(Flight.FlightStatus flightStatus,
                                                              LocalDateTime startedAt) {
        return flightRepository.getAllByFlightStatusAndStartedAtAfter(flightStatus, startedAt);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }
}
