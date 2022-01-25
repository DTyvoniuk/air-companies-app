package com.example.air_companies_app.service.impl;

import com.example.air_companies_app.model.AirCompany;
import com.example.air_companies_app.model.Airplane;
import com.example.air_companies_app.repository.AirplaneRepository;
import com.example.air_companies_app.service.AirCompanyService;
import com.example.air_companies_app.service.AirplaneService;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyService airCompanyService;

    public AirplaneServiceImpl(AirplaneRepository airplaneRepository,
                               AirCompanyService airCompanyService) {
        this.airplaneRepository = airplaneRepository;
        this.airCompanyService = airCompanyService;
    }

    @Override
    public Airplane getById(Long id) {
        return airplaneRepository.getById(id);
    }

    @Override
    public Airplane saveOrUpdate(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane moveAirplaneToAnotherCompany(Long airplane_id, Long airCompany_id) {
        Airplane airplane = getById(airplane_id);
        AirCompany airCompany = airCompanyService.getById(airCompany_id);
        airplane.setAirCompany(airCompany);
        return airplane;
    }
}
