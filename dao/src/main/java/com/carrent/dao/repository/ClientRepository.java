package com.carrent.dao.repository;

import com.carrent.dao.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findByName(String name);
    void delete(Long id);
    void update(Client client);
}
