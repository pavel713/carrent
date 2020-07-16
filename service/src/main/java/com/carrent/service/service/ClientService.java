package com.carrent.service.service;


import com.carrent.dao.entities.Client;


import java.util.List;

public interface ClientService {


    void save(Client client);

    void update(Client client);

    void delete(Long id);

    List<Client> listClient();

    void getClientById(Long id);

}




