package com.example.nutrimeal.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.nutrimeal.repository.MethodesPratiquesRepository;


public class MethodesPratiquesRepositoryTests {
 	
	
	@Autowired
	MethodesPratiquesRepository methodesPratiquesRepository;
	
	//Test de la méthode de split de la liste d'id en String et convertion en Long
	@Test
	public void separationIdStringTest() throws Exception {
		
		String listeIdAsString = "12,13,14,17";

		List<Long> listeIdAsLong = methodesPratiquesRepository.convertirStringIdEnListeLong(listeIdAsString);
		
		Assert.assertTrue(listeIdAsLong.size() == 4);
		Assert.assertTrue(listeIdAsLong.contains(12L) && listeIdAsLong.contains(13L)
				&& listeIdAsLong.contains(14L) && listeIdAsLong.contains(17L));
	}
}