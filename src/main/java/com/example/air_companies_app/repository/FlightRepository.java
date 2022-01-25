package com.example.air_companies_app.repository;

import java.time.LocalDateTime;
import java.util.List;
import com.example.air_companies_app.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> getAllByAirCompany_Name(String name);

    List<Flight> getAllByFlightStatusAndStartedAtAfter(Flight.FlightStatus flightStatus,
                                                       LocalDateTime startedAt);
}
