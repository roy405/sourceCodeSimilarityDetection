package com.example.app.demo.Models;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {



    private @Id
    @GeneratedValue
    Integer id;


    private String addressFirst;
    private String addressSecond;
    private String addressDelivery;


    @ManyToMany(mappedBy = "address")
    private List<User> user;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Orders> orders;



    public Address(){


    }

    public Address(String addressFirst, String addressSecond, String addressDelivery) {
        this.addressFirst = addressFirst;
        this.addressSecond = addressSecond;
        this.addressDelivery = addressDelivery;
    }
}


