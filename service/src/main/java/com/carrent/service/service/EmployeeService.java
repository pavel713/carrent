package com.carrent.service.service;


import com.carrent.dao.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    void delete(Long id);

    List<Employee> findAll();

    void getEmployeeById(Long id);

}

