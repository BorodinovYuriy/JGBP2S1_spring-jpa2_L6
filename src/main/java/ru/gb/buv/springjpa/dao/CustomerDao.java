package ru.gb.buv.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.buv.springjpa.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {
}