package com.Andrey.TestTask.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatisticsService {

    List<Object[]> getSportComplexesWithCountOfVisitsInfo();
    List<Object[]> getCountOfClientsVisitsInfo();
}
