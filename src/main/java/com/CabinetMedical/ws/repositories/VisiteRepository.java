package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.VisiteEntity;
@Repository
public interface VisiteRepository extends JpaRepository<VisiteEntity, Long> {

}
