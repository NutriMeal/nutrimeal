package com.example.nutrimeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nutrimeal.entity.Recette;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long>{

}
