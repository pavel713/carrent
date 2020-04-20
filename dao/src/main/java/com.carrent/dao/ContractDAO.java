package com.carrent.dao;


import com.carrent.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    Contract getByID(int id) throws ClassNotFoundException, SQLException;

    void update(Contract contracts) throws SQLException;

    List<Contract> findAllContracts() throws ClassNotFoundException, SQLException;

    void delete(Contract contracts);
}
