package com.Andrey.TestTask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final EntityManager entityManager;

    @Autowired
    public StatisticsServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Object[]> getSportComplexesWithCountOfVisitsInfo() {
        Query query = entityManager.createNativeQuery("SELECT SC.NAME,SC.ADDRESS, COUNT(*) AS VISITS FROM VISITS V\n" +
                "JOIN SPORT_COMPLEX SC ON V.SPORT_COMPLEX_ID = SC.ID\n" +
                "GROUP BY SC.NAME,SC.ADDRESS ORDER BY VISITS DESC;");
        return query.getResultList();
    }

    @Override
    public List<Object[]> getCountOfClientsVisitsInfo() {
        Query query = entityManager.createNativeQuery("SELECT C.FIRST_NAME, C.LAST_NAME,C.TEL_NO, COUNT(*) AS VISITS FROM VISITS V\n" +
                "JOIN CLIENT C ON V.CLIENT_ID = C.ID\n" +
                "GROUP BY C.FIRST_NAME, C.LAST_NAME ORDER BY VISITS DESC;");
        return query.getResultList();
    }
}
