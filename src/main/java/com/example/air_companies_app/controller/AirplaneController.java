package com.example.air_companies_app.controller;

import com.example.air_companies_app.dto.request.AirplaneRequestDto;
import com.example.air_companies_app.dto.response.AirplaneResponseDto;
import com.example.air_companies_app.model.Airplane;
import com.example.air_companies_app.service.AirplaneService;
import com.example.air_companies_app.service.mapper.AirplaneMapper;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService airplaneService;
    private final AirplaneMapper airplaneMapper;

    public AirplaneController(AirplaneService airplaneService,
                              AirplaneMapper airplaneMapper) {
        this.airplaneService = airplaneService;
        this.airplaneMapper = airplaneMapper;
    }

    @PostMapping
    public AirplaneResponseDto add(@RequestBody AirplaneRequestDto dto) {
        Airplane airplane = airplaneMapper.parseToModel(dto);
        airplaneService.saveOrUpdate(airplane);
        return airplaneMapper.parseToDto(airplane);
    }

    @PatchMapping("/move")
    public AirplaneResponseDto moveAirplaneToAnotherCompany(
            @RequestParam(value = "airplane_id") Long airplaneId,
            @RequestParam(value = "company_id") Long companyId) {
        return airplaneMapper.parseToDto(
                airplaneService.moveAirplaneToAnotherCompany(airplaneId, companyId));
    }
}
