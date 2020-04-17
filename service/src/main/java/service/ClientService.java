package com.prokat.service;

import com.prokat.connection.ConnectionManager;
import com.prokat.dao.ClientDAO;
import com.prokat.dao.ClientDAOImpl;
import com.prokat.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientService extends ConnectionManager implements ClientDAO {

    private static final String FIND_CLIENT = "SELECT * FROM client where name=?";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE id=?";
    private static ClientService INSTANCE = null;

    private ClientService() {
    }

    public static ClientService getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientService();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Client getByID(long id) {
        Client client = new Client();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CLIENT);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                new Client(rs.getString("name"), rs.getString("passport"), rs.getString("address"), rs.getInt("phone"), rs.getString("password"));
            }
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return client;

    }

    @Override
    public void addClient(Client client) {
        ClientDAOImpl.getInstance().addClient(client);
    }


    @Override
    public List<Client> findAllClients() {
        return ClientDAOImpl.getInstance().findAllClients();
    }


    @Override
    public void delete(Client clients) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT);
            preparedStatement.setLong(1, clients.getId());

            System.out.print("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean findByNameAndPassword(Client client) {
        return false;
    }


}

