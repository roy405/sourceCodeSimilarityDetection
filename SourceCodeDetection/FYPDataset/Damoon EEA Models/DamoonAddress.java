package com.deltahaze.straitscommerce.Models;

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
    private String city;
    private String zip_code;
    private String country;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy= "addresses", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @ManyToMany(mappedBy = "address")
    private List<Product> products;

    public Address() {
    }

}
