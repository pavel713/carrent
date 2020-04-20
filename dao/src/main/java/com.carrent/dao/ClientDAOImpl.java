package com.carrent.dao;

import com.carrent.Client;
import com.carrent.connection.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    private static final String ADD_CLIENT_QUERY = "INSERT INTO client(name, passport, address, phone, password)  VALUES (?,?,?,?,?)";
    private static final String FIND_CLIENT = "SELECT * FROM client where (name) VALUES (?)";
    private static final String FIND_ALL_CLIENTS = "SELECT * FROM client";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE (id) VALUES (?)";
    private static ClientDAOImpl INSTANCE = null;

    private ClientDAOImpl() {}
    public static ClientDAOImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ClientDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ClientDAOImpl();
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
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CLIENT_QUERY);

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getPassport());
            preparedStatement.setString(3, client.getAddress());
            preparedStatement.setInt(4, client.getPhone());
            preparedStatement.setString(5, client.getPassword());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> findAllClients() {
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CLIENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.print("\nUsers");

            while (resultSet.next()) {
                Client clients = new Client();
                clients.setId((int) resultSet.getLong("id"));
                clients.setName(resultSet.getString("name"));
                clients.setPassport(resultSet.getString("passport"));
                clients.setAddress(resultSet.getString("address"));
                clients.setPhone(resultSet.getInt("phone"));
                clientList.add(clients);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
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



    }






