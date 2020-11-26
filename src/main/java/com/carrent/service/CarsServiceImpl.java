package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.entities.Category;
import com.carrent.dao.repository.CarRepository;
import com.carrent.dto.CarDTO;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarsServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarsServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public void save(CarDTO carDto) throws DataAccessException {
        try {
            Car car = new Car(carDto);
            carRepository.save(car);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public void delete(Long id) throws DataAccessException {
        try {
            carRepository.findCarById(id);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<CarDTO> findAll() throws DataAccessException {
        try {
            List<Car> all = carRepository.findAll();
            return all.stream().map(CarDTO::new).collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }


    @Override
    public CarDTO getCarById(Long id) throws DataAccessException {
        try {
            Car carById = carRepository.findCarById(id);
            return new CarDTO(carById);
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);
        }
    }

    @Override
    public List<CarDTO> findCarByCategory(Category category) throws DataAccessException {
        try {
            List<Car> carByCategory = carRepository.findCarByCategory(category);
            return carByCategory.stream().map(CarDTO::new).collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new ServiceException("message", e);

        }
    }

}







