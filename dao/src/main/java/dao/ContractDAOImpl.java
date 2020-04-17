package com.prokat.dao;

import com.prokat.connection.ConnectionManager;
import com.prokat.entity.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {
    private static final String ADD_CONTRACT_QUERY = "INSERT INTO contract (id) VALUES (?,?,?,?,?,?,?);";
    private static final String FIND_CONTRACT = "SELECT * FROM contract where (id) VALUES (?)";
    private static final String FIND_ALL_CONTRACTS = "SELECT * FROM contract";
    private static final String DELETE_CONTRACT = "DELETE FROM contract WHERE (id) VALUES (?)";
    private static ContractDAOImpl INSTANCE = null;

    private ContractDAOImpl() {}
    public static ContractDAOImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (ContractDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ContractDAOImpl();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public Contract getByID(int id) {
        Contract contract = new Contract();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CONTRACT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                new Contract(rs.getInt("id"), rs.getDate("date_begin"), rs.getDate("date_end"), rs.getInt("clientID"), rs.getInt("car_id"), rs.getInt("employee"));
            }
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return contract;
    }

    @Override
    public void update(Contract contracts) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_CONTRACT_QUERY);
            preparedStatement.setLong(1, contracts.getId());
            preparedStatement.setDate(2, contracts.getDate_begin());
            preparedStatement.setInt(3, contracts.getClient_id());
            preparedStatement.setInt(4, contracts.getCar_id());
            preparedStatement.setInt(5, contracts.getEmployee());
            preparedStatement.executeUpdate();
            System.out.print("Update");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Contract> findAllContracts(int id) {
        List<Contract> contractList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CONTRACTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.print("\nUsers");

            while (resultSet.next()) {
                Contract contract = new Contract();
                contract.setId(resultSet.getInt("id"));
                contract.setDate_begin(Date.valueOf(resultSet.getString("date_begin")));
                contract.setDate_end(Date.valueOf(resultSet.getString("date_end")));
                contract.setClient_id(resultSet.getInt("client_id"));
                contract.setCar_id(resultSet.getInt("car_id"));
                contract.setEmployee(resultSet.getInt("employee"));
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void delete(Contract contracts) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CONTRACT);
            preparedStatement.setLong(1, contracts.getId());
            System.out.print("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

