package com.CabinetMedical.ws.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.PatientDto;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository PatientRepository;
	
	@Override
	public PatientDto getPatientById(Long patientId) {
		PatientEntity patientEntity= PatientRepository.findByPatientId(patientId);
		if(patientEntity == null)throw new RuntimeException("aucun patient dans la base de donnée avec cette id");
		
		ModelMapper modelMapper = new ModelMapper();
		
		PatientDto patientDto = modelMapper.map(patientEntity, PatientDto.class);
		
		return patientDto;
	}

}
