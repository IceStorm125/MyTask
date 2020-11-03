package com.Andrey.TestTask.service;

import com.Andrey.TestTask.model.SportComplex;
import org.springframework.stereotype.Service;

@Service
public interface SportComplexService {
    void save(SportComplex sportComplex);
    SportComplex getById(Long id);
}
