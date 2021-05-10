package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PreInformationEtatEntity;
@Repository
public interface PreInformationEtatRepository extends JpaRepository<PreInformationEtatEntity, Long> {

	PreInformationEtatEntity findByInfoId(Long infoId);
	@Query(value = "select * from pre_info_etat where patient_id like :patientId",nativeQuery = true)
	PreInformationEtatEntity findByPatinetId(@Param("patientId") Long patientId);
}
