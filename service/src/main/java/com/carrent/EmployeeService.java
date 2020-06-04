package com.carrent;


import java.util.List;


public class EmployeeService implements EmployeeDAO {
    private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employee (id) VALUES (?,?,?);";
    private static final String FIND_EMPLOYEE = "SELECT * FROM employee where (id) VALUES (?)";
    private static final String FIND_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String DELETE_EMPLOYEE = "DELETE FROM damage WHERE (id) VALUES (?)";
    private static EmployeeService INSTANCE = null;

    private EmployeeService() {
    }

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

    public Employee getByID(int id) {EmployeeDAOImpl.getInstance().getByID(id);

        return null;
    }

    public void update(Employee employee) { EmployeeDAOImpl.getInstance().update(employee);
    }
   public List<Employee> findAllEmployees() { return EmployeeDAOImpl.getInstance().findAllEmployees();

        }

    public void delete(Employee employee) {
        EmployeeDAOImpl.getInstance().delete(employee);
    }
}

