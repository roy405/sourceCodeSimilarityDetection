package com.apiit.stadia.ModelClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.apiit.stadia.EnumClasses.OrderStatus;
import com.apiit.stadia.EnumClasses.PaymentMethod;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Orders implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="email",referencedColumnName="email") 
	@Getter @Setter User user;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="shippingId",referencedColumnName="id")
	@Getter @Setter Address shippingAddress;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="billingId",referencedColumnName="id")
	@Getter @Setter Address billingAddress;
	
	@OneToMany(mappedBy="orders")
	@Getter @Setter List<OrderProducts> orderProducts;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter long id;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter OrderStatus status;
	
	@Getter @Setter Date purchasedDate;
	
	@Getter @Setter Date deliverDate;
	
	@Getter @Setter Date orderCompleteDate;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter PaymentMethod paymentMethod;

	public Orders() {
		
	}

	public Orders(User user, OrderStatus status, Date purchasedDate) {
		super();
		this.user = user;
		this.status = status;
		this.purchasedDate = purchasedDate;
	}



}
