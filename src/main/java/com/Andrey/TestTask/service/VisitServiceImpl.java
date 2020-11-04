package com.Andrey.TestTask.service;

import com.Andrey.TestTask.DTO.VisitDTO;
import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Discount;
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
    private final DiscountService discountService;

    @Autowired
    public VisitServiceImpl(VisitRepository visitRepository, ClientService clientService,
                            SportComplexService sportComplexService, DiscountService discountService) {
        this.visitRepository = visitRepository;
        this.clientService = clientService;
        this.sportComplexService = sportComplexService;
        this.discountService = discountService;
    }

    @Override
    public void save(VisitDTO visitDTO) {
        Visit visit = new Visit();

        Client client = clientService.getById(visitDTO.getClient_id());

        visit.setClient(client);
        visit.setSportComplex(sportComplexService.getById(visitDTO.getSport_complex_id()));
        visit.setVisitDate(new Date());

        updateClientDiscountFactor(visitDTO.getClient_id());

        visitRepository.save(visit);
    }

    void updateClientDiscountFactor(Long clientId){

        Discount discount = discountService.getById(clientId);

        if (discount==null){
            Discount newDiscount = new Discount();
            newDiscount.setClient(clientService.getById(clientId));
            newDiscount.setDiscountFactor(0d);
            discountService.save(newDiscount);
        }else {
            Client client = clientService.getById(clientId);
            int countOfVisits = getCountOfVisits(client);

            if (countOfVisits>5){
                discount.setDiscountFactor(1.5d);
            }
            if (countOfVisits>10){
                discount.setDiscountFactor(3d);
            }
            if (countOfVisits>20){
                discount.setDiscountFactor(5d);
            }
            discountService.save(discount);
        }

    }

    @Override
    public List<Visit> getAll() {
        return visitRepository.findAll();
    }

    @Override
    public int getCountOfVisits(Client client) {
        return visitRepository.countAllByClient(client);
    }
}
