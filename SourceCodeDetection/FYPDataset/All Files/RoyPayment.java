package com.example.Komponent.Komponent.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String card_type;
    private String card_number;
    private String card_expiery;
    private String card_cvv;

    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Orders> orders;

    public Payment() {
    }


}
