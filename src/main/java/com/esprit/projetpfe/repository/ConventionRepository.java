package com.esprit.projetpfe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.projetpfe.entities.Convention;

@Repository
public interface ConventionRepository extends CrudRepository<Convention, Integer> {

}
