package com.CabinetMedical.ws.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.CertificatEntity;
@Repository
public interface CertificatRepository extends JpaRepository<CertificatEntity, Long> {

}
