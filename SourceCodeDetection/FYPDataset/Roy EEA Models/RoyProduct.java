package com.example.Komponent.Komponent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String name;
    private String description;
    private String brand;
    private int quantity;
    private double price;
    private String scaledImage;
    private String fullImage;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_address",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> address;

    public Product() {
    }


}
