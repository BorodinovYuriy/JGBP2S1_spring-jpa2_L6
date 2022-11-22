package ru.gb.buv.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "data")
    private String data;

    @ManyToOne(cascade = CascadeType.REMOVE)//...не уверен -надо ли...
    @JoinColumn(name = "customer_id")//столбец с записями отсылок к клиентам
    private Customer customer;

    @ManyToOne(cascade = CascadeType.REMOVE)//...не уверен -надо ли...
    @JoinColumn(name = "product_id")//столбец с записями отсылок к продуктам
    private Product product;

    public Order() {
    }
    public Long getId() {
        return id;
    }//id - обязательно без сеттера!!!
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return  "{ "+
                customer.getLogin() +
                " id= " + id +
                ", product= " + product.getTitle()+
                ", quantity= " + quantity +
                ", data= " + getData() +
                " }";
    }

    private String getData() {
        return data;
    }
}
