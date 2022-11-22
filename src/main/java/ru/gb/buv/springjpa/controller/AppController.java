package ru.gb.buv.springjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.buv.springjpa.entity.Customer;
import ru.gb.buv.springjpa.entity.Order;
import ru.gb.buv.springjpa.entity.Product;
import ru.gb.buv.springjpa.service.CustomerService;
import ru.gb.buv.springjpa.service.OrderService;
import ru.gb.buv.springjpa.service.ProductService;
import java.util.List;


@Controller
public class AppController {
    private ProductService productService;
    private CustomerService customerService;
    private OrderService orderService;

    public AppController(ProductService productService
            , CustomerService customerService
            , OrderService orderService) {
        this.productService = productService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @GetMapping("/auth")
    public String auth (@RequestParam(required = false) String login){
        if (login == null) return "auth";
        else return "redirect:/market/"+login;
    }
    @GetMapping("/market/{login}")
    public String market (@PathVariable String login, Model model){
        //проверку сделать....
        Customer customer = customerService.findAndReturnCustomerByLogin(login);
        model.addAttribute("customer", customer);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "/market";
    }
    @PostMapping("/market/add_order")
    public String addOrder(@RequestParam(value = "customer_id") Long  customer_id
            ,@RequestParam(value = "product_id") Long  product_id){
        Customer c = customerService.findAndReturnCustomerById(customer_id);
        System.out.println(c.getLogin());
        orderService.add(customer_id,product_id);
        return "redirect:/market/"+c.getLogin();

    }


    @GetMapping("/market/orders/{customerId}")
    @ResponseBody
    public List<Order> getAllOrdersByCustomerId(@PathVariable Long customerId){
        return orderService.orderList(customerId);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getListAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/products/delete/{id}")
    @ResponseBody
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
    @PostMapping("/products/add")
    @ResponseBody
    public void addNewProduct(@RequestBody Product p){
        productService.addNewProduct(p);
    }

/*    @GetMapping("/product/change_quantity")
    public void changeProductQuantity(@RequestParam Long productId
            ,@RequestParam Integer quantity){
        customerService.changeCartInCustomer(productId,quantity);
    }*/


}
