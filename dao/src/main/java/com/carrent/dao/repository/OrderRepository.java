package com.carrent.dao.repository;

import com.carrent.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {
}
