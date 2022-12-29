package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Payment {

    private @Id
    @GeneratedValue
    Integer id;

    private String paymentMethodType;
    private String card;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Orders> orders;


    @ManyToOne()
    private User user;

    public Payment() {
    }
}
