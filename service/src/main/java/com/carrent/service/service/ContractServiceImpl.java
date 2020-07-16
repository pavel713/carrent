package com.carrent.service.service;

import com.carrent.dao.entities.Contract;
import com.carrent.dao.repository.ContractRepository;

import java.util.List;

public class ContractServiceImpl implements ContractService {

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void update(Contract contract) {
        contractRepository.update(contract);

    }

    @Override
    public void delete(Long id) {
        contractRepository.delete(id);

    }

    @Override
    public List<Contract> listContract() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Override
    public void getContractById(Long id) {
        contractRepository.findById(id);
    }
}
