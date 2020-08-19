package com.carrent.dao.repository;

import com.carrent.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);


}
