package ru.gb.buv.springjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.buv.springjpa.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

}

