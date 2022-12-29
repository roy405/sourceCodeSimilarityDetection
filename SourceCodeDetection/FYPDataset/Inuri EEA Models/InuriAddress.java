package com.apiit.clothStack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name= "address")


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Address {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id private Integer id;
	
	private String lane;
	private String streetName;
	private Integer postalCode;
	private String country;


	
	 @ManyToOne

	    @JoinColumn(name = "user_id", nullable = false)
	    private User user ;
	
}
