package com.apiit.clothStack.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name= "Cart")

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(columnDefinition="text")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product ;


}
