package com.example.nutrimeal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nutrimeal.model.BilanSemaine;
import com.example.nutrimeal.model.RecetteIngredient;
import com.example.nutrimeal.model.ListeRecettesBilanSemaine;
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
	 * 		Liste de RECETTE.ID_RECETTE en string, nombres séparés par des virgules (ex : "12,14,15")
	 * @return vitaminesTotales
	 * 		Retourne le bilan en minéraux de la recette (Double)
	 * @throws Exception 
	 */
	public Double calculVitaminesPourListeRecette(String listeIdAsString) throws Exception {
	
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
 * 			Liste de RECETTE.ID_RECETTE en string, nombres séparés par des virgules (ex : "12,14,15")
 * @return minerauxTotaux
 * 			Retourne le bilan en minéraux de la recette (Double)
 * @throws Exception 
 */
	public Double calculMinerauxPourListeRecettes(String listeIdAsString) throws Exception {
		
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
	
	
/**
 * 	Méthode qui renvoie un JSON pour le calcul du bilan de la semaine
 * 
 * @param listeIdAsString
 * 		Liste de RECETTE.ID_RECETTE en string, nombres séparés par des virgules (ex : "12,14,15")
 * @return
 * 		Un objet BilanSemaine qui sera renvoyé en JSON
 * @throws Exception
 */
public BilanSemaine bilanSemaine(String listeIdAsString) throws Exception{
				
		
		List<ListeRecettesBilanSemaine> listeRecette = new ArrayList<>();
		Double bilanVitaminesTotales = 0d;
		Double bilanMinerauxTotaux = 0d;
		
		BilanSemaine bilan = new BilanSemaine();
		
		for(String idAsString : listeIdAsString.split(",")) {
			
			Long idAsLong = Long.parseLong(idAsString);
			
			Double bilanVitaminiqueParRecette = calculVitaminesPourListeRecette(idAsString);
			Double bilanMineralParRecette = calculMinerauxPourListeRecettes(idAsString);
			
			bilanVitaminesTotales += bilanVitaminiqueParRecette;
			bilanMinerauxTotaux += bilanMineralParRecette;
			
			ListeRecettesBilanSemaine recette = new ListeRecettesBilanSemaine();
			recette.setIdRecette(idAsLong);
			recette.setMinerauxParRecette(bilanMineralParRecette);
			recette.setVitaminesParRecette(bilanVitaminiqueParRecette);
			recette.setNomRecette(recetteService.getRecetteById(idAsLong).getNomRecette());
			listeRecette.add(recette);
		}
		bilan.setRecettes(listeRecette);
		bilan.setBilanMineral(bilanMinerauxTotaux);
		bilan.setBilanVitaminal(bilanVitaminesTotales);
		
		
		return bilan;
		
	}
		
	
	
	
}
