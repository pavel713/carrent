package com.carrent.service;

import java.util.Date;

public interface PriceService {

    Long calculatePrice(Date startDate, Date endDate, Long carId);
}
