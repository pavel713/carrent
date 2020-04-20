package com.carrent.dao;


import com.carrent.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee getByID(int id) throws ClassNotFoundException, SQLException;

    void update(Employee employee);

    List<Employee> findAllEmployees();

    void delete(Employee employee);
}
