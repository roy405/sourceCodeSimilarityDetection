package com.example.app.demo.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    private @Id
    @GeneratedValue
    Integer id;

    private String first_name;
    private String last_Name;
    private String username;
    private String email;
    private String password;
    private String cellphone;
    private String dob;
    private int userType;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Orders> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "users_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "address_address_id", referencedColumnName = "id"))
    private List<Address> address;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Payment> payments;


    public User() {
    }

}



