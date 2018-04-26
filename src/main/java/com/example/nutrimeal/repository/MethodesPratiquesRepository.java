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
	public List<Long> convertirStringIdEnListeLong(String listeAsString){
		
		List<Long> listeIdAsLong = new ArrayList<Long>();
	
		for(String idAsString : listeAsString.split(",")) {
			listeIdAsLong.add(Long.parseLong(idAsString));
		}
		return listeIdAsLong;
	}
}
