package com.carrent.dao.repository;

import com.carrent.dao.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {



}
