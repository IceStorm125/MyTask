package com.Andrey.TestTask.service;

import com.Andrey.TestTask.DTO.VisitDTO;
import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Visit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VisitService {
    void save(VisitDTO visitDTO);
    List<Visit> getAll();
    int getCountOfVisits(Client client);
}
