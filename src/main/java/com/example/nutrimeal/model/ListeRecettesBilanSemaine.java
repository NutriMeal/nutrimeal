package com.example.nutrimeal.model;

import lombok.Getter;
import lombok.Setter;

public class ListeRecettesBilanSemaine {

	@Getter
	@Setter
	private Long idRecette;
	
	@Getter
	@Setter
	private Double vitaminesParRecette;
	
	@Getter
	@Setter
	private Double minerauxParRecette;
	
	@Getter
	@Setter
	private String nomRecette;	
}
