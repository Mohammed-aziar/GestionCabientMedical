package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PresciptionEntity;
@Repository
public interface PresciptionRepository extends JpaRepository<PresciptionEntity, Long> {

}
