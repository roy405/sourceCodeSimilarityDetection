package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cart {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String date;
    private int cart_quantity;
    private double order_total;
    private double total_cost;

    @OneToOne
    private Orders orders;

    @OneToOne
    private User user;

    @OneToOne
    private Payment payment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> product;

    public Cart(){

    }

}
