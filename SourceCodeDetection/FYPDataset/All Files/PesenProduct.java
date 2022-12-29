package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Product {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String product_name;
    private String product_details;
    private String product_brand;
    private int quantity;
    private double price;
    private String img;

    @ManyToMany(mappedBy = "product")
    private List<Orders> orders;

    public Product() {
    }
}
