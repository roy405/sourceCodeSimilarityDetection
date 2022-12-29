package com.apiit.stadia.ModelClasses;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class OrderProducts implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@Getter @Setter OrderProductsIdentity OrderProductsId;

	@ManyToOne(cascade=CascadeType.DETACH)
	@MapsId("orderId")
	@JoinColumn(name="orderId",referencedColumnName="id")
	@Getter @Setter Orders orders;

	@ManyToOne(cascade=CascadeType.DETACH)
	@MapsId("prodId")
	@JoinColumn(name="prodId",referencedColumnName="id")
	@Getter @Setter ProductSizes productSizes;
	
	@OneToOne(mappedBy="orderProducts")
	@Getter @Setter Rating rating;
	

	
	@Getter @Setter int quantity;
	
	public OrderProducts() {}

	public OrderProducts(Orders orders, ProductSizes productSizes, OrderProductsIdentity orderProductsId, int quantity) {
		super();
		this.orders = orders;
		this.productSizes = productSizes;
		this.OrderProductsId = orderProductsId;
		this.quantity = quantity;
	}

	
	
	
	
}
