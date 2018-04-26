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
	
	@RequestMapping(value = "/bilan/{listeId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getListeId(@PathVariable("listeId") String listeIdAsString){	
		
		Double bilanVitaminique = calculService.calculVitaminesParRecette(listeIdAsString);
		Double bilanMineral = calculService.calculMinerauxParRecette(listeIdAsString);
		
		BilanSemaine bilan = new BilanSemaine();
	
		bilan.setBilanMineral(bilanMineral);
		bilan.setBilanVitaminal(bilanVitaminique);
		
		
		if (!listeIdAsString.isEmpty()) {
			return new ResponseEntity<>(bilan, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(bilan, HttpStatus.NOT_FOUND);
		}
	}
	
}
