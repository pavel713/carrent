package com.carrent.dao.repository;

import com.carrent.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);

    void delete(Long id);
}
