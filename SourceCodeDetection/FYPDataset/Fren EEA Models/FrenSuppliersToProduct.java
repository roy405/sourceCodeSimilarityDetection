package com.example.app.demo.Models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SuppliersToProduct {

    private @Id
    @GeneratedValue
    Integer supplier_product_id;


    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product pdr;

    @ManyToOne
    @MapsId("suppliers_id")
    @JoinColumn(name = "suppliers_id")
    Suppliers spr;

    int pOrder;

}
