package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.MedicamentEntity;
@Repository
public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {
	MedicamentEntity findByMedicamentId(long medicamentId);
	@Query(value="select * from medicament m where m.libelle like %:libelle% ",nativeQuery = true)
	MedicamentEntity findByLibelle(@Param("libelle") String libelle);
}
