package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.jws.Oneway;
import javax.persistence.*;
import java.sql.CallableStatement;
import java.util.List;

@Data
@Entity
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String first_name;
    private String last_name;
    private String username;
    private String pwd;
    private String email;
    private String dob;
    private int user_type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Payment> payment;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @OneToOne
    private Cart cart;

    public User() {
    }

}