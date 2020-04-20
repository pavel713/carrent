package com.carrent.dao;


import com.carrent.Damage;

import java.sql.SQLException;
import java.util.List;

public interface DamageDAO {
    Damage getByID(int id) throws ClassNotFoundException, SQLException;

    void update(Damage damage) throws SQLException;

    List<Damage> findAllDamages() throws ClassNotFoundException, SQLException;

    void delete(Damage damage);
}
