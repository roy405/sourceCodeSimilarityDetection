package com.deltahaze.straitscommerce.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Supplier {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String supplier_name;
    private String supplier_description;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Supplier() {
    }

    public Supplier(String supplier_name, String supplier_description) {
        this.supplier_name = supplier_name;
        this.supplier_description = supplier_description;
    }
}
