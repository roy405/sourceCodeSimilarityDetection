package com.example.app.demo.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Data
@Entity
public class Suppliers {

    private @Id
    @GeneratedValue
    Integer id;

    private String SupplierName;
    private String SupplierDescription;


    @OneToMany (mappedBy = "spr")
    private List<SuppliersToProduct> stp;


    public Suppliers(){

    }

    public Suppliers(String supplierName, String supplierDescription) {
        SupplierName = supplierName;
        SupplierDescription = supplierDescription;
    }
}
