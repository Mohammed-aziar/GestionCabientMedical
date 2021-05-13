package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.RDVDto;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.entities.RDVEntity;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.repositories.RDVRepository;
import com.CabinetMedical.ws.services.RDVService;

@Service
public class RDVServiceImpl implements RDVService {
	@Autowired
	RDVRepository rdvRepositor;
	@Autowired
	PatientRepository patientRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public RDVDto getRDVById(Long rdvID) {

		RDVEntity rdvEntity = rdvRepositor.findByRDVId(rdvID);

		if (rdvEntity == null)
			throw new RuntimeException("cette rendez vous n'existez pas");

		RDVDto dto = modelMapper.map(rdvEntity, RDVDto.class);

		dto.setPatientId(rdvEntity.getPatient().getPatientId());

		return dto;
	}

	@Override
	public List<RDVDto> getList() {
		List<RDVEntity> entity = rdvRepositor.findAll();
		List<RDVDto> listDto = new ArrayList<>();
		for (RDVEntity entityEntity : entity) {
			RDVDto rdv = new RDVDto();
			rdv.setRDVId(entityEntity.getRDVId());
			rdv.setDate_RDV(entityEntity.getDate_RDV());
			rdv.setDateCreationRDV(entityEntity.getDateCreationRDV());
			rdv.setPatientId(entityEntity.getPatient().getPatientId());
			listDto.add(rdv);
		}
		return listDto;
	}

	@Override
	public RDVDto createdRDV(RDVDto rdvDto) {

		PatientEntity patient = patientRepository.findByPatientId(rdvDto.getPatientId());

		if (patient == null)
			throw new RuntimeException("cette patient  n'existez pas");

		RDVEntity rdvEntity = new RDVEntity(rdvDto.getDate_RDV(), rdvDto.getDateCreationRDV(), patient);

		RDVEntity createdRdv = rdvRepositor.save(rdvEntity);
		RDVDto dto = new RDVDto();
		dto.setRDVId(createdRdv.getRDVId());
		dto.setDate_RDV(createdRdv.getDate_RDV());
		dto.setDateCreationRDV(createdRdv.getDateCreationRDV());
		dto.setPatientId(createdRdv.getPatient().getPatientId());

		return dto;
	}

	@Override
	public void deleteRdv(Long rdvId) {
		RDVEntity rdvEntity = rdvRepositor.findByRDVId(rdvId);

		if (rdvEntity == null)
			throw new RuntimeException("cette rendez vous n'existez pas");
		
		rdvRepositor.delete(rdvEntity);
	}

	@Override
	public RDVDto updateRDV(Long rdvId, RDVDto rdvDto) {
		RDVEntity checkEntity	=	 rdvRepositor.findByRDVId(rdvId);
		
		if(checkEntity == null)			throw new RuntimeException("cette rendez-vous n'existez pas");
		
		PatientEntity patient = patientRepository.findByPatientId(rdvDto.getPatientId());

		if (patient == null)
			throw new RuntimeException("cette patient  n'existez pas");
		
		checkEntity.setDate_RDV(rdvDto.getDate_RDV());
		checkEntity.setPatient(patient);
		
		RDVEntity updatedRdv= rdvRepositor.save(checkEntity);
		RDVDto dto = new RDVDto();
		dto.setRDVId(updatedRdv.getRDVId());
		dto.setDate_RDV(updatedRdv.getDate_RDV());
		dto.setDateCreationRDV(updatedRdv.getDateCreationRDV());
		dto.setPatientId(updatedRdv.getPatient().getPatientId());
		return dto;
	}

}
