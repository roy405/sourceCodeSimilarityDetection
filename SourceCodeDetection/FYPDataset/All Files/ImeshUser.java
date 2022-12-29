package com.apiit.stadia.ModelClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.apiit.stadia.EnumClasses.Gender;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email",referencedColumnName="email")
	@MapsId("email")
	@Getter @Setter private Login login;
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<Address> address;
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<Orders> orders;
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<Rating> rating;
	
	@Id
	@Getter @Setter private String email;
	
	@Getter @Setter private Date dob;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter private Gender gender;
	
	@Getter @Setter private String contactNo;
	
	public User() {
		
	}

	public User(Login login, String email) {
		super();
		this.login = login;
		this.email = email;
	}
	
	
}
