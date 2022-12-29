package com.apiit.stadia.ModelClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.REMOVE)
	@Getter @Setter List<ProductSizes> productSizes;
	
	@ManyToOne
	@JoinColumn(name="mainSubCatId",referencedColumnName="id")
	@Getter @Setter MainSubCategory mainSubCategory;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.REMOVE)
	@Getter @Setter List<ProductImages> productImages;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter long id;
	
	@Getter @Setter String title;
	
	@Getter @Setter String description;
	
	@Getter @Setter double price;
	
	@Getter @Setter Date createdDate;
	
	@Getter @Setter Date modifyDate;
}
