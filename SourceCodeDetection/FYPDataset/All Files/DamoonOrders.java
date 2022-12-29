package com.deltahaze.straitscommerce.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Orders {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private int no_of_items;
    private double total_price;
    private String order_date;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private User user;

    @ManyToOne
    private Payment payment;

    @ManyToOne
    private Address addresses;

    public Orders(){

    }

    public Orders(int no_of_items, double total_price, String order_date) {
        this.no_of_items = no_of_items;
        this.total_price = total_price;
        this.order_date = order_date;
    }
}
