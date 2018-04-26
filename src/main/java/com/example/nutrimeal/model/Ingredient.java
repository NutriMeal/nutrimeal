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
@Table(name = "INGREDIENT")
public class Ingredient {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_INGREDIENT")
	private Long idIngredient;
	
	 @OneToMany(mappedBy="ingredients")
	 public Set<RecetteIngredient> listeRecettes = new HashSet<>();

	@Column
	private String libelle;
	
	@Column
	private Double quantite;

	@Column(name = "UNITE_MESURE")
	private String uniteMesure;
	
	@Column
	private Double vitamines;
	
	@Column
	private Double mineraux;

	public Long getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(Long idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public String getUniteMesure() {
		return uniteMesure;
	}

	public void setUniteMesure(String uniteMesure) {
		this.uniteMesure = uniteMesure;
	}

	public Double getVitamines() {
		return vitamines;
	}

	public void setVitamines(Double vitamines) {
		this.vitamines = vitamines;
	}

	public Double getMineraux() {
		return mineraux;
	}

	public void setMineraux(Double mineraux) {
		this.mineraux = mineraux;
	}

}
