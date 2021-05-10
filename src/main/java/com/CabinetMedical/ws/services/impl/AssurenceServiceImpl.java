package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.AssurenceDto;
import com.CabinetMedical.ws.entities.AssurenceEntity;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.entities.TypeAssurenceEntity;
import com.CabinetMedical.ws.repositories.AssurenceRepository;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.repositories.TypeAssurenceRepository;
import com.CabinetMedical.ws.services.AssurenceService;

@Service
public class AssurenceServiceImpl implements AssurenceService {
	@Autowired
	AssurenceRepository assurenceRepository;

	@Autowired
	PatientRepository PatientRepository;
	@Autowired
	TypeAssurenceRepository typeAssurenceRepository;

	@Override
	public AssurenceDto getAssurence(long assurenceId) {
		AssurenceEntity assurence = assurenceRepository.findByAssurenceId(assurenceId);
		if (assurence == null)
			throw new RuntimeException("aucun assurence dans la base de donnée avec cette id");
		AssurenceDto dto = new AssurenceDto();
		dto.setPatientId(assurence.getPatient().getPatientId());
		dto.setAssurenceId(assurenceId);
		dto.setTypeAssurenceId(assurence.getListAssurence().getTypeId());
		return dto;
	}

	@Override
	public AssurenceDto createAssurence(AssurenceDto assurence) {
		PatientEntity patient = PatientRepository.findByPatientId(assurence.getPatientId());

		if (patient == null)
			throw new RuntimeException("patient n'existe pas");

		TypeAssurenceEntity typeAssurence = typeAssurenceRepository.findByTypeId(assurence.getTypeAssurenceId());

		if (typeAssurence == null)
			throw new RuntimeException("type assurence n'existe pas");

		AssurenceEntity checkAssurence = assurenceRepository.findByPatientId(assurence.getPatientId());

		if (checkAssurence != null)
			throw new RuntimeException("cette assuernce existe déjà");

		AssurenceEntity assurenceEntity = new AssurenceEntity(null, patient, typeAssurence);

		AssurenceEntity entity = assurenceRepository.save(assurenceEntity);

		AssurenceDto createdAssuernce = new AssurenceDto(entity.getAssurenceId(), entity.getPatient().getPatientId(),
				entity.getListAssurence().getTypeId());

		return createdAssuernce;
	}

	@Override
	public void deleteAssurence(Long assurenceId) {

		AssurenceEntity check = assurenceRepository.findByAssurenceId(assurenceId);

		if (check == null)
			throw new RuntimeException("cette assurence n'existe pas");

		assurenceRepository.delete(check);

	}

	@Override
	public List<AssurenceDto> getListAssurence() {
		List<AssurenceDto> assurenceDto = new ArrayList<>();

		List<AssurenceEntity> assurenceEntity = (List<AssurenceEntity>) assurenceRepository.findAll();

		for (AssurenceEntity assurence : assurenceEntity) {
			AssurenceDto dto = new AssurenceDto(assurence.getAssurenceId(), assurence.getPatient().getPatientId(),
					assurence.getListAssurence().getTypeId());
			assurenceDto.add(dto);
		}
		return assurenceDto;
	}

	@Override
	public AssurenceDto updateAssurence(long assurenceId, AssurenceDto assurence) {
		
		AssurenceEntity assurenceEntity = assurenceRepository.findByAssurenceId(assurenceId);
		
		if (assurenceEntity == null)
			throw new RuntimeException("cette assurence n'existe pas");

		TypeAssurenceEntity typeAssurence = typeAssurenceRepository.findByTypeId(assurence.getTypeAssurenceId());
		
		assurenceEntity.setListAssurence(typeAssurence);
		
		AssurenceEntity UpdatedAssurence = assurenceRepository.save(assurenceEntity);

		AssurenceDto Dto = new AssurenceDto(UpdatedAssurence.getAssurenceId(), UpdatedAssurence.getPatient().getPatientId(),UpdatedAssurence.getListAssurence().getTypeId());

		return Dto;
	}

}
