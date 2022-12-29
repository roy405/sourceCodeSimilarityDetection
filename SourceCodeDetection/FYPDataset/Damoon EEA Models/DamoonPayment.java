package com.deltahaze.straitscommerce.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Payment {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String payment_type;
    private String card_type;
    private String card_name;
    private String card_number;
    private String card_expiry_date;
    private String cvv;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Payment() {
    }

    public Payment(String payment_type, String card_type, String card_name, String card_number, String card_expiry_date, String cvv) {
        this.payment_type = payment_type;
        this.card_type = card_type;
        this.card_name = card_name;
        this.card_number = card_number;
        this.card_expiry_date = card_expiry_date;
        this.cvv = cvv;
    }
}
