package ru.gb.buv.springjpa.controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.buv.springjpa.entity.Product;
import ru.gb.buv.springjpa.service.ProductService;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/t")
    public String test(){
        return "TEST";
    }

    @GetMapping("/products")
    public List<Product> getListAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
    @PostMapping("/products/add")
    public void addNewProduct(@RequestBody Product p){
        productService.addNewProduct(p);
    }
}
