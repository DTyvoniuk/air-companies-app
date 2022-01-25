package com.example.air_companies_app.repository;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import javax.annotation.PostConstruct;
import com.example.air_companies_app.model.AirCompany;
import com.example.air_companies_app.model.Airplane;
import com.example.air_companies_app.model.Flight;
import com.example.air_companies_app.service.AirCompanyService;
import com.example.air_companies_app.service.AirplaneService;
import com.example.air_companies_app.service.FlightService;
import org.springframework.stereotype.Component;

@Component
public class InitializeMockData {
    private final AirCompanyService airCompanyService;
    private final AirplaneService airplaneService;
    private final FlightService flightService;

    public InitializeMockData(AirCompanyService airCompanyService,
                              AirplaneService airplaneService,
                              FlightService flightService) {
        this.airCompanyService = airCompanyService;
        this.airplaneService = airplaneService;
        this.flightService = flightService;
    }

    @PostConstruct
    public void initialize() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("air_company");
        airCompany.setCompanyType("awesome type");
        airCompany.setFoundedAt(LocalDate.now());
        airCompanyService.saveOrUpdate(airCompany);
        Airplane airplane = new Airplane();
        airplane.setFactorySerialNumber(1);
        airplane.setAirCompany(airCompany);
        airplane.setNumberOfFlight(0);
        airplane.setFlightDistance(10000);
        airplane.setFuelCapacity(100);
        airplane.setType("Awesome type of airplane");
        airplane.setCreatedAt(LocalDate.now());
        airplaneService.saveOrUpdate(airplane);
        Flight flight = new Flight();
        flight.setFlightStatus(Flight.FlightStatus.COMPLETED);
        flight.setAirCompany(airCompany);
        flight.setAirplane(airplane);
        flight.setDepartureCountry("Ukraine");
        flight.setDestinationCountry("Italy");
        flight.setEstimatedFlightTime(Duration.of(5L, ChronoUnit.HOURS));
        flight.setStartedAt(LocalDateTime.now().plusHours(2));
        flight.setEndedAt(LocalDateTime.now().plusHours(20));
        flight.setDelayStartedAt(LocalTime.now().plusHours(0));
        flight.setCreatedAt(LocalDate.now().minusYears(5));
        flightService.saveOrUpdate(flight);
    }
}
