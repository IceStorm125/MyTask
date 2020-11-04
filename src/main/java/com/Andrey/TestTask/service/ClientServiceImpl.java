package com.Andrey.TestTask.service;

import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Discount;
import com.Andrey.TestTask.repository.ClientRepository;
import com.Andrey.TestTask.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final DiscountRepository discountRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, DiscountRepository discountRepository) {
        this.clientRepository = clientRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Discount getClientDiscountById(Long id) {
        return discountRepository.getOne(id);
    }
}
