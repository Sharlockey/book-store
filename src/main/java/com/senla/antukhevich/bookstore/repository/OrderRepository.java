package com.senla.antukhevich.bookstore.repository;

import com.senla.antukhevich.bookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends JpaRepository<Order, Long> {

}
