package com.deltahaze.straitscommerce.Models;

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
    private String dob;
    private int user_type;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Orders> order;

    @OneToOne
    private Cart cart;

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
    private List<Payment> payments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> addresses;

    public User() {
    }

    public User(String first_name, String last_name, String username, String email, String password, String dob, int user_type) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.user_type = user_type;
    }
}



