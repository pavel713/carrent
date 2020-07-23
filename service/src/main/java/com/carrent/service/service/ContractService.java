package com.carrent.service.service;


import com.carrent.dao.entities.Contract;

import java.util.List;

public interface ContractService {

    void save(Contract contract);



    void delete(Long id);

    List<Contract> listContract();

    void getContractById(Long id);
}

