package com.example.air_companies_app.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirplaneResponseDto {
    private Long id;
    private int factorySerialNumber;
    private Long airCompanyId;
    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    private String type;
    private String createdAt;
}
