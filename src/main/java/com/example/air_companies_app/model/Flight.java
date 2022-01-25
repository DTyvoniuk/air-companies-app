package com.example.air_companies_app.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flights")
@NoArgsConstructor
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status")
    private FlightStatus flightStatus;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;
    @Column(name = "departure_country")
    private String departureCountry;
    @Column(name = "destination_country")
    private String destinationCountry;
    private int distance;
    @Column(name = "estimated_flight_time")
    private Duration estimatedFlightTime;
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @Column(name = "endedAt")
    private LocalDateTime endedAt;
    @Column(name = "delay_started_at")
    private LocalTime delayStartedAt;
    @Column(name = "created_at")
    private LocalDate createdAt;

    public static enum FlightStatus {
        ACTIVE,
        COMPLETED,
        DELAYED,
        PENDING
    }
}
