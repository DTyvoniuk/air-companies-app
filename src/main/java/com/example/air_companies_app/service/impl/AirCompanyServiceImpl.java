package com.example.air_companies_app.service.impl;

import com.example.air_companies_app.model.AirCompany;
import com.example.air_companies_app.repository.AirCompanyRepository;
import com.example.air_companies_app.service.AirCompanyService;
import org.springframework.stereotype.Service;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public AirCompany getById(Long id) {
        return airCompanyRepository.getById(id);
    }

    @Override
    public AirCompany saveOrUpdate(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }
}
