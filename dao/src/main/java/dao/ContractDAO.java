package com.prokat.dao;

import com.prokat.entity.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    Contract getByID(int id) throws ClassNotFoundException, SQLException;

    void update(Contract contracts) throws SQLException;

    List<Contract> findAllContracts(int id) throws ClassNotFoundException, SQLException;

    void delete(Contract contracts);
}
