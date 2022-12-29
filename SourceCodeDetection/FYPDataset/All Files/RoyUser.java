package com.example.Komponent.Komponent.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;
    private String cell_phone;
    private String dob;
    private int userType;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
    private List<Payment> payment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> address;


    public User() {
    }

}
