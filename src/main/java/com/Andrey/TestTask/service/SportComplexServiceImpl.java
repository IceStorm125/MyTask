package com.Andrey.TestTask.service;

import com.Andrey.TestTask.model.SportComplex;
import com.Andrey.TestTask.repository.SportComplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportComplexServiceImpl implements SportComplexService {

    private final SportComplexRepository sportComplexRepository;

    @Autowired
    public SportComplexServiceImpl(SportComplexRepository sportComplexRepository) {
        this.sportComplexRepository = sportComplexRepository;
    }

    @Override
    public void save(SportComplex sportComplex) {
        sportComplexRepository.save(sportComplex);
    }

    @Override
    public SportComplex getById(Long id) {
        return sportComplexRepository.findById(id).orElse(null);
    }
}
