package com.esprit.projetpfe.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.projetpfe.entities.Role;
import com.esprit.projetpfe.entities.RoleName;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>  {

	Role findByName(RoleName roleName);
}
