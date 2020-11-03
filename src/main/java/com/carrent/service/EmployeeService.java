package com.carrent.service;


import com.carrent.dao.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    void delete(Long id);

    List<Employee> findAll();

    Employee findEmployeeById(Long id);

}

