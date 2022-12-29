package com.deltahaze.straitscommerce.Models;

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
    private int quantity;
    private double price;
    private String details;
    private String product_scaled_image;
    private String product_enlarged_image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_address",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> address;

    public Product() {
    }

    public Product(String product_name, int quantity, double price, String details, String product_scaled_image, String product_enlarged_image) {
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
        this.details = details;
        this.product_scaled_image = product_scaled_image;
        this.product_enlarged_image = product_enlarged_image;
    }
}
