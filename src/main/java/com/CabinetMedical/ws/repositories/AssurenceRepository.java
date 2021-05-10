package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.AssurenceEntity;
@Repository
public interface AssurenceRepository extends JpaRepository<AssurenceEntity, Long> {

	AssurenceEntity findByAssurenceId(long assurenceId);
	
	@Query(value="select * from assurence where patient_id like :patient",nativeQuery = true)
	AssurenceEntity findByPatientId(@Param("patient")long patinetId);
}
