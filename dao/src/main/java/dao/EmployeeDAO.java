package com.prokat.dao;

import com.prokat.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    Employee getByID(int id) throws ClassNotFoundException, SQLException;

    void update(Employee employee) throws SQLException;

    List<Employee> findAllEmployees(int id) throws ClassNotFoundException, SQLException;

    void delete(Employee employee);
}
