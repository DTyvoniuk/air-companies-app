package com.example.air_companies_app.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "airplanes")
@NoArgsConstructor
@Getter
@Setter
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "factory_serial_number")
    private int factorySerialNumber;
    @ManyToOne
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;
    @Column(name = "number_of_flight")
    private int numberOfFlight;
    @Column(name = "flight_distance")
    private int flightDistance;
    @Column(name = "fuel_capacity")
    private int fuelCapacity;
    private String type;
    @Column(name = "created_at")
    private LocalDate createdAt;
}
