package com.example.nutrimeal.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@IdClass(value = RecetteIngredient.class)
@Table(name = "RECETTE_INGREDIENT")
public class RecetteIngredient implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_RECETTE")
	private Long idRecette;
	
	@Id
	@Column(name = "ID_INGREDIENT")
	private Long idIngredient;
	
	@ManyToOne
    @JoinColumn(name="ID_RECETTE", nullable=false, insertable= false, updatable=false)
    public Recette recette;
	
	@Column
	private Double quantite;

	@ManyToOne
    @JoinColumn(name="ID_INGREDIENT", nullable=false, insertable= false, updatable=false)
    public Ingredient ingredients;
	
	
	
	public Ingredient getIngredients() {
		return ingredients;
	}

	public void setIngredients(Ingredient ingredients) {
		this.ingredients = ingredients;
	}

	public Long getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(Long idRecette) {
		this.idRecette = idRecette;
	}

	public Long getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Long idIngredient) {
		this.idIngredient = idIngredient;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
