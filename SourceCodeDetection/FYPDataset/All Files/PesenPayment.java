package com.example.gamesCentral.gamesCentral.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Payment {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String payment_method;
    private String cardNo;
    private String expiery_date;
    private String cvv;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Orders> orders;


    @ManyToOne
    private User user;

    public Payment() {

    }

    public Payment(String payment_method, String cardNo, String expiery_date, String cvv) {
        this.payment_method = payment_method;
        this.cardNo = cardNo;
        this.expiery_date = expiery_date;
        this.cvv = cvv;
    }
}
