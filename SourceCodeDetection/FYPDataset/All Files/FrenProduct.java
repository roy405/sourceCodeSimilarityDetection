package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    private @Id
    @GeneratedValue
    Integer id;

    private String name;
    private String description;
    private String brand;
    private String quantity;
    private String price;
    private String scaledImage;
    private String fullImage;

    @OneToMany(mappedBy = "pdr")
    private List<OrdersToProduct> otp;

    @OneToMany(mappedBy = "pdr")
    private List<SuppliersToProduct> stp;

    @ManyToOne
    private Cart cart;

    public Product() {
    }

}
