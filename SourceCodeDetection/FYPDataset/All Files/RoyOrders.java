package com.example.Komponent.Komponent.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Orders {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private double order_total;
    private String order_date;

    @OneToOne
    private Cart cart;


    @ManyToOne
    private User user;


    @ManyToOne
    private Payment payment;


    @ManyToOne
    private Address address;

    public Orders(){}




}
