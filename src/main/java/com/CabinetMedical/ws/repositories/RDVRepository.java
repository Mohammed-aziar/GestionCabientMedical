package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.RDVEntity;
@Repository
public interface RDVRepository extends JpaRepository<RDVEntity, Long> {
}
