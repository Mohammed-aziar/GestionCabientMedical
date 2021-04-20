package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.TypeAssurenceEntity;
@Repository
public interface TypeAssurenceRepository extends JpaRepository<TypeAssurenceEntity, Long> {

}
