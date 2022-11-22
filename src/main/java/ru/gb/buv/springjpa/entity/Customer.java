package ru.gb.buv.springjpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


    public Customer() {
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public List<Order> allOrderList(){
        return orders;
    }
    public String allOrderListToString(){
        List<Order> l = orders;
        StringBuilder sb = new StringBuilder();
        l.forEach(list -> sb.append(list.toString()));
        return sb.toString();
    }

}
