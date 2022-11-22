package ru.gb.buv.springjpa.service;

import org.springframework.stereotype.Service;
import ru.gb.buv.springjpa.dao.OrderDao;
import ru.gb.buv.springjpa.entity.Order;

import java.util.List;

@Service
public class OrderService {
    private final OrderDao orderDao;
    private final ProductService productService;
    private final CustomerService customerService;

    public OrderService(OrderDao orderDao, ProductService productService, CustomerService customerService) {
        this.orderDao = orderDao;
        this.productService = productService;
        this.customerService = customerService;
    }

    public List<Order> orderList(Long customerId){
        return orderDao.findCustomerOrders(customerId);
    }

    public void add(Long customerId, Long productId) {
        Order o = new Order();
        o.setCustomer(customerService.findAndReturnCustomerById(customerId));
        o.setProduct(productService.getProductById(productId));

        orderDao.save(o);
    }
}
