package com.carrent.service.service;

import com.carrent.dao.entities.Client;
import com.carrent.dao.repository.ClientRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }


    @Override
    public void delete(Long id) {
        clientRepository.delete(id);

    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @Override
    public void getClientById(Long id) {

    }


}

