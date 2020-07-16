package com.carrent.dao.repository;

import com.carrent.dao.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Employee findByName(String name);

    void update(Employee employee);

    void delete(Long id);
}
