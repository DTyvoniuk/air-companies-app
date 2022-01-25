package com.example.air_companies_app.service;

import com.example.air_companies_app.model.AirCompany;

public interface AirCompanyService {
    AirCompany getById(Long id);

    AirCompany saveOrUpdate(AirCompany airCompany);
}
