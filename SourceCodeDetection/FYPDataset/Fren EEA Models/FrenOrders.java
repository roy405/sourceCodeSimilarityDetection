package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Orders {


    private @Id
    @GeneratedValue
    Integer order_id;

    private String orderStatus;
    private String orderstatusDate;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private Address address;

    @ManyToOne()
    private User user;

    @OneToMany (mappedBy = "odr")
    private List<OrdersToProduct> otp;

    @ManyToOne
    private Payment payment;

    public Orders(){

    }

}
