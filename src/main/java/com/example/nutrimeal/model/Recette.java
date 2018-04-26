package com.example.nutrimeal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "RECETTE")
public class Recette {

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_RECETTE")
    public Long idRecette;	

    @OneToMany(mappedBy="recette")
    public Set<RecetteIngredient> recetteIngredients = new HashSet<>();

	@Column(name = "NOM_RECETTE")
	private String nomRecette;
	
	@Column(name = "TEMPS_PREPARATION")
	private Integer tempsPreparation;

	public Long getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(Long idRecette) {
		this.idRecette = idRecette;
	}

	public Set<RecetteIngredient> getRecetteIngredients() {
		return recetteIngredients;
	}

	public void setRecetteIngredients(Set<RecetteIngredient> recetteIngredients) {
		this.recetteIngredients = recetteIngredients;
	}

	public String getNomRecette() {
		return nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public Integer getTempsPreparation() {
		return tempsPreparation;
	}

	public void setTempsPreparation(Integer tempsPreparation) {
		this.tempsPreparation = tempsPreparation;
	}
	
}
