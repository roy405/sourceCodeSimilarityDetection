package com.apiit.clothStack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name= "review")

@NoArgsConstructor
@ToString
@Getter
@Setter

public class Review {

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id private Integer id;
	private String review;
	private Integer rating;

	 @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user ;


	@ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product ;

}
