package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String street1;
    private String street2;
    private String state;
    private String city;
    private String zip_code;
    private String country;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Address() {
    }

    public Address(String street1, String street2, String state, String city, String zip_code, String country, User user) {
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
        this.city = city;
        this.zip_code = zip_code;
        this.country = country;
        this.user = user;
    }
}

