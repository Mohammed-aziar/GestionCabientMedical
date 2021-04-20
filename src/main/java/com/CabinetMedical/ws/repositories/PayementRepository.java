package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.PayementEntity;
@Repository
public interface PayementRepository extends JpaRepository<PayementEntity, Long> {

}
