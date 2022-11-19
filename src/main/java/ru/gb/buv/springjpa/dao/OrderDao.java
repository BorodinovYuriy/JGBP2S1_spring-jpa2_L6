package ru.gb.buv.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.buv.springjpa.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {
}
