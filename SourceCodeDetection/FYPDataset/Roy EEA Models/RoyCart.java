package com.example.Komponent.Komponent.model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cart {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private double cart_total;
    private double shipping_cost;
    private double taxes;

    @OneToOne
    private User user;

    @OneToOne
    private Orders orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private List<Product> product;

    public Cart() {
    }
}

