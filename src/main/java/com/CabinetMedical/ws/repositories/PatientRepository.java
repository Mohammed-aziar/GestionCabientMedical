package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PatientEntity;
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
	PatientEntity findByPatientId(Long patientId);

}
