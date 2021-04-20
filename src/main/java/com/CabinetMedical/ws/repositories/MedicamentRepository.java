package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.MedicamentEntity;
@Repository
public interface MedicamentRepository extends JpaRepository<MedicamentEntity, Long> {

}
