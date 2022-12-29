package com.example.Komponent.Komponent.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity

public class ExteriorSupplier {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String exterior_supplier_name;
    private String exterior_supplier_description;

    @OneToMany(mappedBy = "exteriorSupplier", cascade = CascadeType.ALL)
    private List<Address> address;

    public ExteriorSupplier() {
    }
}
