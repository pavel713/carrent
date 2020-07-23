package com.carrent.dao.repository;

import com.carrent.dao.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    void delete(Long id);
}
