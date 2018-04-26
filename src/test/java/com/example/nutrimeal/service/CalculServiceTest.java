package com.example.nutrimeal.service;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.nutrimeal.model.Ingredient;
import com.example.nutrimeal.model.Recette;
import com.example.nutrimeal.model.RecetteIngredient;

public class CalculServiceTest {

	@Autowired
	CalculService calculService;
	
	@Autowired
	private EntityManager em;
	
	@Test
	public void calculMineraux() {
		
		Recette recette = new Recette();
		recette.setIdRecette(1L);
		recette.setNomRecette("Lasagnes");	
		em.persist(recette);
		
		RecetteIngredient recetteIngredient = new RecetteIngredient();
		recetteIngredient.setIdIngredient(1L);
		recetteIngredient.setIdRecette(1L);
		recetteIngredient.setQuantite(3d);
		em.persist(recetteIngredient);
		
		Ingredient ingredient = new Ingredient();
		ingredient.setLibelle("Barbaque");
		ingredient.setMineraux(140d);
		ingredient.setIdIngredient(1L);
		em.persist(ingredient);
		
		Double calcul = calculService.calculMinerauxParRecette("1");
		
		calcul = calcul + 2;
		
	}
	
	
}
