package com.apiit.clothStack.entity;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name= "user")

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id private Integer id;
	
	private String username;
	private String password;
	private String email;
	private String mobile;
    private String role;



	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Review> reviews;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Cart> carts;

	
	
}
