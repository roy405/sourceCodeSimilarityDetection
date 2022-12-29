package com.apiit.stadia.ModelClasses;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.apiit.stadia.DTOClasses.MainSubCategoryDTO;
import com.apiit.stadia.EnumClasses.Gender;

import lombok.Getter;
import lombok.Setter;

@Entity
public class MainCategory implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade={CascadeType.MERGE})
	@JoinTable(
			  name = "main_sub_category", 
			  joinColumns = @JoinColumn(name = "mainId", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "subId", referencedColumnName = "id"))
	@Getter @Setter List<SubCategory> subCategory;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter int id;
	

	@Getter @Setter String mainCatTitle;
	
	@Getter @Setter String mainCatDesc;
	
	@Getter @Setter String mainCatImg;
	
	@Enumerated(EnumType.STRING)
	@Getter @Setter Gender type;
}
