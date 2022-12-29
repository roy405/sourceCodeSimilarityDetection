package com.apiit.clothStack.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name= "product")

@Getter
@Setter
@NoArgsConstructor


public class Product {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id private Integer id;

	private String productName;
	
	private String productDescription;
	
	private Integer quantity;
	
	private String productImage;

	private String shortDescription;
	
	private Integer price;
	
	
	 @ManyToOne
	 @JoinColumn(name = "category_id")
	 private Category category ;


	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<Cart> carts;

	@JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Review> Reviews;
	
	
	
	
	
	
	
}
