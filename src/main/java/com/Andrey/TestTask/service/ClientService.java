package com.Andrey.TestTask.service;

import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client getById(Long id);

    void save(Client client);

    void delete(Long id);

    List<Client> getAll();

    Discount getClientDiscountById(Long id);
}