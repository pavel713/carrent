package com.carrent.service.service;

import com.carrent.dao.entities.Contract;
import com.carrent.dao.repository.ContractRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
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
    public void delete(Long id) {
        contractRepository.delete(id);

    }

    @Override
    public List<Contract> listContract() {
        return contractRepository.findAll();
    }

    @Override
    public void getContractById(Long id) {
        contractRepository.findById(id);
    }
}
