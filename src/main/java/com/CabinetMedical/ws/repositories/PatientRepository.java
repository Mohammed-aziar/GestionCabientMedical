package com.CabinetMedical.ws.repositories;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PatientEntity;


@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
	
	PatientEntity findByPatientId(Long patientId);
	
	PatientEntity findByCin(String cin);
	
	
	@Query(value = "SELECT * FROM PATIENTS P "
			+ "WHERE CONCAT(p.nom,' ', p.prenom ) LIKE  %:nom% "
			+ " OR"
			+" CONCAT(p.prenom,' ', p.nom ) LIKE  %:nom%",nativeQuery=true)
	List <PatientEntity> findAllPatientByNomPrenom(@Param("nom") String nom);
	
	
}
