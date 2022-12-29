package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Cart {

    private @Id
    @GeneratedValue
    Integer id;

    private String cartDate;

    @OneToOne
    private User user;

    @OneToOne
    private Orders orders;

    @OneToOne
    private Payment payment;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

    private double total;

    public Cart(){

    }

}
