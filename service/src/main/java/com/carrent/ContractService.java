package com.carrent;


import com.carrent.dao.ContractDAO;
import com.carrent.dao.ContractDAOImpl;

import java.util.List;

public class ContractService implements ContractDAO {
    private static final String ADD_CONTRACT_QUERY = "INSERT INTO contract (id) VALUES (?,?,?,?,?,?,?);";
    private static final String FIND_CONTRACT = "SELECT * FROM contract where (id) VALUES (?)";
    private static final String FIND_ALL_CONTRACTS = "SELECT * FROM contract";
    private static final String DELETE_CONTRACT = "DELETE FROM contract WHERE (id) VALUES (?)";
    private static ContractService INSTANCE = null;

    private ContractService() {
    }

    public static ContractService getInstance() {
        if (INSTANCE == null) {
            synchronized (ContractService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ContractService();
                }
            }
        }
        return INSTANCE;
    }


    @Override
    public Contract getByID(int id) {
        ContractDAOImpl.getInstance().getByID(id);

        return null;
    }

    public void update(Contract contract) {
        ContractDAOImpl.getInstance().update(contract);
    }

    public List<Contract> findAllContracts() {
        return ContractDAOImpl.getInstance().findAllContracts();
    }

    public void delete(Contract contract) {
        ContractDAOImpl.getInstance().delete(contract);
    }
}

