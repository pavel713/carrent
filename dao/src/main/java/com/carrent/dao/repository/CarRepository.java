package com.carrent.dao.repository;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);

    List<Car> findCarByCategory(Category category);
}
