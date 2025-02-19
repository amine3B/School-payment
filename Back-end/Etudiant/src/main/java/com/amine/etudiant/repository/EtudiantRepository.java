package com.amine.etudiant.repository;

import com.amine.etudiant.entity.Classe;
import com.amine.etudiant.entity.Etudiant;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

}
