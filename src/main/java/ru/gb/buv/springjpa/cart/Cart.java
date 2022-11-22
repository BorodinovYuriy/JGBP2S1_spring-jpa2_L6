package ru.gb.buv.springjpa.cart;

import ru.gb.buv.springjpa.entity.Product;
import java.util.HashMap;


public class Cart {
    HashMap<Product,Integer> cartMap;

    public Cart() {
        this.cartMap = new HashMap<Product,Integer>();
    }

    public void addToCart(Product p, int quantity){
        cartMap.put(p,quantity);
    }
    public void deleteProductFromCart(Product p){
        cartMap.remove(p);
    }
    public HashMap<Product,Integer> getCartMap(){
        return cartMap;
    }

}
