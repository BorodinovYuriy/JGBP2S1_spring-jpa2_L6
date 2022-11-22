package ru.gb.buv.springjpa.service;

import org.springframework.stereotype.Service;
import ru.gb.buv.springjpa.dao.CustomerDao;
import ru.gb.buv.springjpa.entity.Customer;
import ru.gb.buv.springjpa.entity.Order;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer findAndReturnCustomerById(Long id){
        return customerDao.getReferenceById(id);
    }
    public void saveNewCustomer(Customer c) {
        customerDao.save(c);
    }
    public void deleteCustomer(Customer c) {
        //можно проверку вставить
        customerDao.delete(c);
    }
    public boolean checkCustomer(String login){
        //реализация проверки....
        return true;//заглушка
    }
    public Customer findAndReturnCustomerByLogin(String login){
        return customerDao.findCustomerByLogin(login);
    }
    public List<Order> allOrderList(Customer c){
        return c.allOrderList();//test!
    }

}
