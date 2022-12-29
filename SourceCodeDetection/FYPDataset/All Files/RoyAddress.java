package com.example.Komponent.Komponent.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Data
@Entity
public class Address {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String street1;
    private String street2;
    private String state;
    private String city;
    private String zip_code;
    private String country;
    private String address_type;

    @ManyToMany(mappedBy = "address")
    private List<User> user;

    @ManyToOne
    private ExteriorSupplier exteriorSupplier;


    @OneToMany(mappedBy= "address", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @ManyToMany(mappedBy = "address")
    private List<Product> product ;

    public Address() {
    }


}
