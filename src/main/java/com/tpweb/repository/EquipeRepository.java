package com.tpweb.repository;

import com.tpweb.models.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpweb.models.*;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
