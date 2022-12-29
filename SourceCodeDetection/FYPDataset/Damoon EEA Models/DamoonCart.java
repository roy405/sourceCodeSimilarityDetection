package com.deltahaze.straitscommerce.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cart {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private int quantity;
    private double cart_total;

    @OneToOne
    private User user;

    @OneToOne
    private Orders order;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> products;

    public Cart() {
    }

    public Cart(int quantity, double cart_total) {
        this.quantity = quantity;
        this.cart_total = cart_total;
    }
}
