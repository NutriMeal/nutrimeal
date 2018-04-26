package com.example.nutrimeal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nutrimeal.model.RecetteIngredient;
import com.example.nutrimeal.repository.MethodesPratiquesRepository;

/**
 * 
 * @author Gaetan Inidjel
 *
 */
@Service
public class CalculService {

	@Autowired
	RecetteService recetteService;
	
	@Autowired
	MethodesPratiquesRepository methodes;
	
	/**
	 * La méthode qui somme les vitamines des ingrédients de la recette
	 * 
	 * @param listeIdAsString
	 * 		Liste de RECETTE.ID_RECETTE en string, nombres séparés par des virgules
	 * @return vitaminesTotales
	 * 		Retourne le bilan en minéraux de la recette (Double)
	 */
	public Double calculVitaminesParRecette(String listeIdAsString) {
	
	// La liste d'id est convertie de String vers List<Long>.
	List<Long> listeIdAsLong = methodes.convertirStringIdEnListeLong(listeIdAsString);
	
	Double vitaminesTotales = 0d;
	
	//Pour chaque idRecette
	for(Long idRecette : listeIdAsLong) {
		
		// Les ingrédients sont récupérés
		Set<RecetteIngredient> ingredients = recetteService.getRecetteById(idRecette).getRecetteIngredients();
		
		// Pour chaque ingrédient, la quantité est multipliée par les vitamines par ingrédient.
		for(RecetteIngredient ingredient : ingredients) {
			
			vitaminesTotales += ingredient.getQuantite()*ingredient.getIngredients().getVitamines();
			
			}
		}
		return vitaminesTotales;
	}
/**
 * Méthode qui somme les minéraux des ingrédients de la recette
 * 
 * @param listeIdAsString
 * 			Liste de RECETTE.ID_RECETTE en string, nombres séparés par des virgules
 * @return minerauxTotaux
 * 			Retourne le bilan en minéraux de la recette (Double)
 */
	public Double calculMinerauxParRecette(String listeIdAsString) {
		
		// La liste d'id est convertie de String vers List<Long>.
		List<Long> listeIdAsLong = methodes.convertirStringIdEnListeLong(listeIdAsString);
		
		Double minerauxTotaux = 0d;
		
		//Pour chaque idRecette
		for(Long id : listeIdAsLong) {
	
			// Les ingrédients sont récupérés
			Set<RecetteIngredient> ingredients = recetteService.getRecetteById(id).getRecetteIngredients();
			
			// Pour chaque ingrédient, la quantité est multipliée par les minéraux par ingrédient.
			for(RecetteIngredient ingredient : ingredients) {
			
				minerauxTotaux += ingredient.getQuantite()*ingredient.getIngredients().getMineraux();
			}
		}
		return minerauxTotaux;
	}
}
