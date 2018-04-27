package com.example.nutrimeal.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Gaetan Inidjel
 *
 */
public class BilanSemaine {

	@Getter
	@Setter
	private Double bilanVitaminal;
	
	@Getter
	@Setter
	private Double BilanMineral;
	
	@Getter
	@Setter
	private List<ListeRecettesBilanSemaine> recettes;
	
}
