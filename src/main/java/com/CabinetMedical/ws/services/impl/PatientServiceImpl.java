package com.CabinetMedical.ws.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.CabinetMedical.ws.dto.PatientDto;
import com.CabinetMedical.ws.entities.PatientEntity;
import com.CabinetMedical.ws.repositories.PatientRepository;
import com.CabinetMedical.ws.services.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PatientDto getPatientById(Long patientId) {
//		PatientEntity patientEntity= patientRepository.findByPatientId(patientId);
		PatientEntity patientEntity = (PatientEntity) patientRepository.findAll();
		if (patientEntity == null)
			throw new RuntimeException("aucun patient dans la base de donnée avec cette id");


		PatientDto patientDto = modelMapper.map(patientEntity, PatientDto.class);

		return patientDto;
	}

	@Override
	public List<PatientDto> getPatients(int page, int limit) {
		if (page > 0)
			page -= page;

		List<PatientDto> patinetDto = new ArrayList<>();
		PageRequest pageable = PageRequest.of(page, limit);

		Page<PatientEntity> PatientsEntities = patientRepository.findAllPatientByPrenom(pageable);


		for (PatientEntity patient : PatientsEntities) {
			PatientDto dto = modelMapper.map(patient, PatientDto.class);
			patinetDto.add(dto);
		}

		return patinetDto;
	}

	@Override
	public PatientDto createPatient(PatientDto patient) {

		PatientEntity checkPatient = patientRepository.findByCin(patient.getCin());

		if (checkPatient != null)
			throw new RuntimeException("ce patient existe déjà");

		PatientEntity patientEntity = modelMapper.map(patient, PatientEntity.class);

		PatientEntity patinetEntity2 = patientRepository.save(patientEntity);

		PatientDto createdPatient = modelMapper.map(patinetEntity2, PatientDto.class);

		return createdPatient;
	}

	@Override
	public void deletePatinet(Long patientId) {
		PatientEntity Patient = patientRepository.findByPatientId(patientId);
		if (Patient == null)
			throw new RuntimeException("ce patient n'existe pas");

		patientRepository.delete(Patient);

	}

	@Override
	public PatientDto updatePatient(long patientId, PatientDto patientDto) {
		PatientEntity Patient = patientRepository.findByPatientId(patientId);
		if (Patient == null)
			throw new RuntimeException("ce patient n'existe pas");
		Patient.setNom(patientDto.getNom());
		Patient.setPrenom(patientDto.getPrenom());
		Patient.setAdresse(patientDto.getAdresse());
		Patient.setTel(patientDto.getTel());
		Patient.setEmail(patientDto.getEmail());
		Patient.setSexe(patientDto.getSexe());
		Patient.setCin(patientDto.getCin());
		Patient.setPrefession(patientDto.getPrefession());
		Patient.setSagn(patientDto.getSagn());
		Patient.setDateNaissance(patientDto.getDateNaissance());
		PatientEntity UpdatedPatient = patientRepository.save(Patient);
		
		PatientDto Dto = modelMapper.map(UpdatedPatient, PatientDto.class);
		
		return Dto;
	}

}
