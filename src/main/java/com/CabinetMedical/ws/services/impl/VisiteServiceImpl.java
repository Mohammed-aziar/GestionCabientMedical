package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.VisiteDto;
import com.CabinetMedical.ws.entities.VisiteEntity;
import com.CabinetMedical.ws.repositories.VisiteRepository;
import com.CabinetMedical.ws.services.VisiteService;

@Service
public class VisiteServiceImpl implements VisiteService {

	@Autowired
	VisiteRepository visiteRepository;

	@Override
	public VisiteDto getByVisiteId(Long visiteId) {
		VisiteEntity checkVisite = visiteRepository.findByVisiteId(visiteId);
		if (checkVisite == null)
			throw new RuntimeException("cette visite n'exist pas");
		VisiteDto visiteDto = new VisiteDto(checkVisite.getVisiteId(), checkVisite.getDateDebut(),
				checkVisite.getDateFin(), checkVisite.getMotif(), checkVisite.getType(), checkVisite.getDiagnostic(),
				checkVisite.getCommantaire(), checkVisite.getPatient().getPatientId());
		return visiteDto;
	}

	@Override
	public List<VisiteDto> getListVisiteByPatientId(Long patientId) {
		int checkVisitePatient = visiteRepository.CountPatientId(patientId);
		if (checkVisitePatient == 0)throw new RuntimeException("cette patinet auccan visite");
		
		List<VisiteEntity> visiteEntity = visiteRepository.findByPatientId(patientId);
		List<VisiteDto> visiteDto=new ArrayList<>();
		for(VisiteEntity visite :	visiteEntity ) {
			
			VisiteDto Dto = new VisiteDto(visite.getVisiteId(), visite.getDateDebut(),
					visite.getDateFin(), visite.getMotif(), visite.getType(), visite.getDiagnostic(),
					visite.getCommantaire(), visite.getPatient().getPatientId());
			visiteDto.add(Dto);
		}
		
			return visiteDto;
	}

}
