package com.carrent.service.service;

import com.carrent.dao.entities.Employee;
import com.carrent.dao.repository.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee);

    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);

    }

    @Override
    public List<Employee> listEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void getEmployeeById(Long id) {
        employeeRepository.findById(id);

    }
}
