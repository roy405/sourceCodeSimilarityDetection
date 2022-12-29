package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class Orders {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String order_date;
    private double total_price;
    private String status;

    @ManyToOne
    private User user;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private Payment payment;


    @ManyToOne
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_product",
            joinColumns = @JoinColumn(name = "orders_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> product;

    private Orders(){

    }

    public Orders(String order_date, double total_price, String status, User user, Cart cart, List<Product> product) {
        this.order_date = order_date;
        this.total_price = total_price;
        this.status = status;
        this.user = user;
        this.cart = cart;
        this.product = product;
    }
}
