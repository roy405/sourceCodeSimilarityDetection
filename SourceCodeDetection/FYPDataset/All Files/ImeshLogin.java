package com.apiit.stadia.ModelClasses;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.apiit.stadia.EnumClasses.UserRole;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Getter @Setter private String email;
	
	@Getter @Setter private String pass;
	
	@Getter @Setter private String fName;
	
	@Getter @Setter private String lName;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter private UserRole role;
	
	@Getter @Setter private Date lastLogin;

	public Login() {
		
	}
	
	public Login(String email, String pass, String fName, String lName, UserRole role, Date lastLogin) {
		super();
		this.email = email;
		this.pass = pass;
		this.fName = fName;
		this.lName = lName;
		this.role = role;
		this.lastLogin = lastLogin;
	}

	public Login(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
}
