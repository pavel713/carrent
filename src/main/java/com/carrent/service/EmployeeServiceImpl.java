package com.carrent.service;

import com.carrent.dao.entities.Employee;
import com.carrent.dao.repository.EmployeeRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void save(Employee employee) throws DataAccessException {
        try {
            employeeRepository.save(employee);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            employeeRepository.deleteById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<Employee> findAll() throws DataAccessException {
        try {
            return employeeRepository.findAll();
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }

    @Override
    public Employee findEmployeeById(Long id) throws DataAccessException {
        try {
            return employeeRepository.findEmployeeById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }

    }


}

