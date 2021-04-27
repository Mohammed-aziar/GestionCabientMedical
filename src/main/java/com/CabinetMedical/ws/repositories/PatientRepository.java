package com.CabinetMedical.ws.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PatientEntity;


@Repository
public interface PatientRepository extends PagingAndSortingRepository<PatientEntity, Long> {
	PatientEntity findByPatientId(Long patientId);
	
	PatientEntity findByCin(String cin);
	
	@Query(value = "select * from patients p "
			+ "  where p.prenom='mohammed'",nativeQuery = true)
	Page<PatientEntity> findAllPatientByPrenom(PageRequest pageable);
}
