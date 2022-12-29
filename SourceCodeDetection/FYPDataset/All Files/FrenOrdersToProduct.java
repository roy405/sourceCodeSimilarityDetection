package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.valueextraction.UnwrapByDefault;

@Data
@Entity
public class OrdersToProduct {

    private @Id
    @GeneratedValue
    Integer order_product_id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product pdr;

    @ManyToOne
    @MapsId("orders_id")
    @JoinColumn(name = "orders_id")
    Orders odr;

    int Oty;

}
