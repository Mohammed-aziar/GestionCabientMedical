package com.CabinetMedical.ws.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabinetMedical.ws.entities.AnalyseEntity;
@Repository
public interface AnalyseRepository extends JpaRepository<AnalyseEntity, Long> {

}
