package com.example.nutrimeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutrimeal.model.BilanSemaine;
import com.example.nutrimeal.repository.MethodesPratiquesRepository;
import com.example.nutrimeal.service.CalculService;

/**
 * 
 * @author Gaetan Inidjel
 *
 */
@RestController
public class HomeController {

	@Autowired
	MethodesPratiquesRepository methodes;
	
	@Autowired
	CalculService calculService;
	
	/**
	 * Méthode du restController qui export en PDF les recettes sélectionnées dans l'onglet Bilan
	 * 
	 * @param listeIdAsString
	 * 			Liste d'ID sous forme de chaine de caractères (ex : "12,13,42")
	 * @return
	 * 			Export pdf du bilan de la semaine
	 * @throws Exception 
	 */
	@RequestMapping(value = "/bilan/{listeId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getListeId(@PathVariable("listeId") String listeIdAsString) throws Exception{	
		
		BilanSemaine bilan = calculService.bilanSemaine(listeIdAsString);
		
		if ((bilan != null) && (bilan != null)) {
			return new ResponseEntity<>(bilan, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(bilan, HttpStatus.BAD_GATEWAY);
		}
	}
	
}
