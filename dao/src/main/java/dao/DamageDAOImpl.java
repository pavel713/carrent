package com.prokat.dao;

import com.prokat.connection.ConnectionManager;
import com.prokat.entity.Contract;
import com.prokat.entity.Damage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DamageDAOImpl implements DamageDAO {
    private static final String ADD_DAMAGE_QUERY = "INSERT INTO damage (id) VALUES (?,?,?,?);";
    private static final String FIND_DAMAGE = "SELECT * FROM damage where (id) VALUES (?)";
    private static final String FIND_ALL_DAMAGES = "SELECT * FROM damage";
    private static final String DELETE_DAMAGE = "DELETE FROM damage WHERE (id) VALUES (?)";
    private static DamageDAOImpl INSTANCE = null;

    private DamageDAOImpl() {}
    public static DamageDAOImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (DamageDAOImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DamageDAOImpl();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public Damage getByID(int id) {
        Damage damage = new Damage();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_DAMAGE);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                new Contract(rs.getInt("id"), rs.getInt("contract_id"), rs.getDate("date"), rs.getString("result"));
            }
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return damage;
    }

    @Override
    public void update(Damage damage) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_DAMAGE_QUERY);
            preparedStatement.setLong(1, damage.getId());
            preparedStatement.setInt(2, damage.getContract_id());
            preparedStatement.setDate(3, damage.getDate());
            preparedStatement.setString(4, damage.getResult());
            preparedStatement.executeUpdate();
            System.out.print("Update");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Damage> findAllDamages(int id) throws ClassNotFoundException, SQLException {
        List<Damage> damageList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_DAMAGE);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.print("\nUsers");

            while (resultSet.next()) {
                Damage damage = new Damage();
                damage.setId(resultSet.getInt("id"));
                damage.setId(resultSet.getInt("contract_id"));
                damage.setDate(Date.valueOf(resultSet.getString("date")));
                damage.setResult(resultSet.getString("result"));


                damageList.add(damage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return damageList;
    }

    @Override
    public void delete(Damage damage) {
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DAMAGE);
            preparedStatement.setLong(1,damage.getId());
            preparedStatement.executeUpdate();
                        System.out.print("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

