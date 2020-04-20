package com.carrent.dao;

import com.carrent.Client;


import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    Client getByID(long id) throws ClassNotFoundException, SQLException;

    void addClient(Client client) throws SQLException;

    List<Client> findAllClients() throws ClassNotFoundException, SQLException;

    void delete(Client clients);


}
