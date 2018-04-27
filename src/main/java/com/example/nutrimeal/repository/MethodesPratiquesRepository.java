package com.example.nutrimeal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author Gaetan Inidjel
 *
 */
@Repository
public class MethodesPratiquesRepository {

	/** Cette méthode reçoit une String de nombres(ex : "12,14,18"), et la convertit en List<Long>
	 * 
	 * @param listeAsString
	 * 			Liste d'id au format String : nombres séparés par des virgules
	 * @return listeIdAsLong
	 */
	public List<Long> convertirStringIdEnListeLong(String listeAsString) throws Exception{
		
		List<Long> listeIdAsLong = new ArrayList<Long>();
	
		try {
		
		for(String idAsString : listeAsString.split(",")) {
			listeIdAsLong.add(Long.parseLong(idAsString));
		}
		
		} catch(Error e) {
			listeIdAsLong = new ArrayList<Long>();
		}
		
		return listeIdAsLong;
	}
	
	/**
	 * Cette méthode prend en entrée un nombre, et le renvoie avec deux chiffres significatifs
	 * 
	 * @param nombre
	 * 			nombre de type Double en entrée
	 * @return nombre de type Double arrondi à deux chiffres significatifs
	 */
	public Double deuxChiffresSignificatifs(Double nombre) {
		
		return Math.round(nombre*100d)/100d;	
		
	}
	
	
	
}
