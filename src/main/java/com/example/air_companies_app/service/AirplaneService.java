package com.example.air_companies_app.service;

import com.example.air_companies_app.model.Airplane;

public interface AirplaneService {
    Airplane getById(Long id);

    Airplane saveOrUpdate(Airplane airplane);

    Airplane moveAirplaneToAnotherCompany(Long airplane_id, Long airCompany_id);
}
