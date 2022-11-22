package ru.gb.buv.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.gb.buv.springjpa.entity.Customer;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long> {
    /*@Transactional(readOnly = true)*/
    @Query(value = "SELECT * FROM lesson_6_schema.customers WHERE login = :name",
            nativeQuery = true)
    Customer findCustomerByLogin(@Param("name") String name);

}