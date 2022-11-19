package ru.gb.buv.springjpa.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.gb.buv.springjpa.dao.ProductDao;
import ru.gb.buv.springjpa.entity.Product;

import java.util.List;
@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public void deleteProductById(Long id) {
        try {
            productDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.printf("There isn't product with id %d", id);
        }
    }

    public void addNewProduct(Product p) {
        productDao.save(p);
    }
}
