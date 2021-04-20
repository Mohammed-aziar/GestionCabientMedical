package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.AssurenceEntity;
@Repository
public interface AssurenceRepository extends JpaRepository<AssurenceEntity, Long> {

}
