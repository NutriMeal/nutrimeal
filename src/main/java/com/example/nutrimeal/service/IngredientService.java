package com.example.nutrimeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nutrimeal.model.Ingredient;
import com.example.nutrimeal.repository.IngredientRepository;

@Service
public class IngredientService {

	
	@Autowired
	IngredientRepository ingredientRepository;
	
	public Ingredient getIngredientById(Long id) {
		return ingredientRepository.getOne(id);
	}
	
	public List<Ingredient> getAll(){
		return ingredientRepository.findAll();
	}
	
	public Optional<Ingredient> getOneById(Long id) {
		return ingredientRepository.findById(id);
	}
}
