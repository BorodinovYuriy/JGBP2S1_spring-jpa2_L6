package ru.gb.buv.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.buv.springjpa.entity.Customer;
import ru.gb.buv.springjpa.entity.Order;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {
    @Query(value = "SELECT * FROM lesson_6_schema.orders WHERE customer_id = :customerId",
            nativeQuery = true)
    List<Order> findCustomerOrders(@Param("customerId") Long customerId);

}
