package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CabinetMedical.ws.entities.TypeAnalyseEntity;

public interface TypeAnalyseRepository extends JpaRepository<TypeAnalyseEntity, Long> {
	TypeAnalyseEntity findByTypeAnalyseId(long typeAnalyseId);
	TypeAnalyseEntity findByLibelle(String libelle);
}
