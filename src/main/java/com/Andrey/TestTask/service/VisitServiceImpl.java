package com.Andrey.TestTask.service;

import com.Andrey.TestTask.DTO.VisitDTO;
import com.Andrey.TestTask.model.Visit;
import com.Andrey.TestTask.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final ClientService clientService;
    private final SportComplexService sportComplexService;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository, ClientService clientService, SportComplexService sportComplexService) {
        this.visitRepository = visitRepository;
        this.clientService = clientService;
        this.sportComplexService = sportComplexService;
    }

    @Override
    public void save(VisitDTO visitDTO) {
        Visit visit = new Visit();
        visit.setClient(clientService.getById(visitDTO.getClient_id()));
        visit.setSportComplex(sportComplexService.getById(visitDTO.getSport_complex_id()));
        visit.setVisitDate(new Date());
        visitRepository.save(visit);
    }

    @Override
    public List<Visit> getAll() {
        return visitRepository.findAll();
    }
}
