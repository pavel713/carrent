package com.prokat.service;

import com.prokat.connection.ConnectionManager;
import com.prokat.dao.EmployeeDAO;
import com.prokat.entity.Contract;
import com.prokat.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends ConnectionManager implements EmployeeDAO {
    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employee (id) VALUES (?,?,?);";
    private static final String FIND_EMPLOYEE = "SELECT * FROM employee where (id) VALUES (?)";
    private static final String FIND_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE = "DELETE FROM damage WHERE (id) VALUES (?)";
    private static EmployeeService INSTANCE = null;

    private EmployeeService() {}
    public static EmployeeService getInstance() {
        if (INSTANCE == null) {
            synchronized (EmployeeService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new EmployeeService();
                }
            }
        }
        return INSTANCE;
    }
    @Override
    public Employee getByID(int id) {
        Employee employee = new Employee();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                new Contract(rs.getInt("id"), rs.getString("name"), rs.getInt("phone"));
            }
        } catch (Exception ex) {
            System.out.print("Error");
        }
        return employee;

    }

    @Override
    public void update(Employee employee) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_QUERY);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setInt(3, employee.getPhone());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> findAllEmployees(int id) {
        List<Employee> employeeList = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.print("\nUsers");
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setPhone(resultSet.getInt("phone"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;

    }

    @Override
    public void delete(Employee employee) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();
            System.out.print("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
