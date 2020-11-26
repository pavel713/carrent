package com.carrent.service;

import com.carrent.dao.entities.Category;
import com.carrent.dto.CarDTO;

import java.util.List;

public interface CarService {

    void save(CarDTO car);

    void delete(Long id);

    List<CarDTO> findAll();

    CarDTO getCarById(Long id);

    List<CarDTO> findCarByCategory(Category category);

}
