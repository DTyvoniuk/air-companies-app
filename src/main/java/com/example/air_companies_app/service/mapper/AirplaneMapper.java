package com.example.air_companies_app.service.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.example.air_companies_app.dto.request.AirplaneRequestDto;
import com.example.air_companies_app.dto.response.AirplaneResponseDto;
import com.example.air_companies_app.model.Airplane;
import com.example.air_companies_app.service.AirCompanyService;
import org.springframework.stereotype.Component;

@Component
public class AirplaneMapper {
    private final AirCompanyService airCompanyService;

    public AirplaneMapper(AirCompanyService airCompanyService) {
        this.airCompanyService = airCompanyService;
    }

    public AirplaneResponseDto parseToDto(Airplane airplane) {
        AirplaneResponseDto dto = new AirplaneResponseDto();
        dto.setId(airplane.getId());
        dto.setFactorySerialNumber(airplane.getFactorySerialNumber());
        dto.setAirCompanyId(airplane.getAirCompany().getId());
        dto.setNumberOfFlight(airplane.getNumberOfFlight());
        dto.setFlightDistance(airplane.getFlightDistance());
        dto.setFuelCapacity(airplane.getFuelCapacity());
        dto.setType(airplane.getType());
        dto.setCreatedAt(airplane.getCreatedAt().format(DateTimeFormatter.ISO_DATE));
        return dto;
    }

    public Airplane parseToModel(AirplaneRequestDto dto) {
        Airplane airplane = new Airplane();
        airplane.setFactorySerialNumber(dto.getFactorySerialNumber());
        airplane.setAirCompany(airCompanyService.getById(dto.getAirCompanyId()));
        airplane.setNumberOfFlight(dto.getNumberOfFlight());
        airplane.setFlightDistance(dto.getFlightDistance());
        airplane.setFuelCapacity(dto.getFuelCapacity());
        airplane.setType(dto.getType());
        airplane.setCreatedAt(LocalDate.parse(dto.getCreatedAt(),
                DateTimeFormatter.ISO_DATE));
        return airplane;
    }
}
