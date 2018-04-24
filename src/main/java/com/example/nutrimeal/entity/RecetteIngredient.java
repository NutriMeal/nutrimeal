package com.example.nutrimeal.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class RecetteIngredient {

	@Id
	private Long idRecette;
	
	@Id
	private Long idIngredient;
	
	@Column(name = "QUANTITE")
	private Double quantite;
	
}
