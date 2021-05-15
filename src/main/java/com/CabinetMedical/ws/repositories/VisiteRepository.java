package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.CabinetMedical.ws.entities.VisiteEntity;
@Repository
public interface VisiteRepository extends JpaRepository<VisiteEntity, Long> {

	VisiteEntity findByVisiteId(Long visiteId);
	
	@Query(value="SELECT COUNT(*) FROM visites v WHERE v.patient_id=:patientId",nativeQuery=true)
	int CountPatientId(@Param("patientId") Long patientId);
	
	@Query(value="SELECT * FROM visites v WHERE v.patient_id=:patientId",nativeQuery=true)
	List<VisiteEntity> findByPatientId(@Param("patientId") Long patientId);
}
