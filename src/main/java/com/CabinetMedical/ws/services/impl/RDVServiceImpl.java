package com.CabinetMedical.ws.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.RDVDto;
import com.CabinetMedical.ws.entities.RDVEntity;
import com.CabinetMedical.ws.repositories.RDVRepository;
import com.CabinetMedical.ws.services.RDVService;
@Service
public class RDVServiceImpl implements RDVService {
	@Autowired
	RDVRepository  rdvRepositor; 
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public RDVDto getRDVById(Long rdvID) {
		
		RDVEntity rdvEntity = rdvRepositor.findByRDVId(rdvID);
		
		if(rdvEntity == null)throw new RuntimeException("cette rendez vous n'existez pas");
		
		RDVDto dto = modelMapper.map(rdvEntity, RDVDto.class);
		
		dto.setPatientId(rdvEntity.getPatient().getPatientId());
		
		return dto;
	}

}
