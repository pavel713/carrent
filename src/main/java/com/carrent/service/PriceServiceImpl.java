package com.carrent.service;

import com.carrent.dao.entities.Car;
import com.carrent.dao.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final CarRepository carRepository;

    @Override
    public Long calculatePrice(Date startDate, Date endDate, Long carId) {
        long daysBetween = ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
        Car car = carRepository.findCarById(carId);
        long price = car.getPrice();
        return price * daysBetween;
    }
}
